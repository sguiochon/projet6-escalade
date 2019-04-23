package sam.ocr.escalade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import sam.ocr.escalade.listener.OnCommentAddedEvent;
import sam.ocr.escalade.model.*;
import sam.ocr.escalade.repository.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentaireService {

    private static final Logger log = LoggerFactory.getLogger(CommentaireService.class);

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private SiteDescriptionRepository siteDescriptionRepository;

    /**
     *
     * @param appUrl
     * @param siteId
     * @param principalName
     * @param content
     * @return message d'erreur ou null si aucune erreur n'est survenue
     */
    public String submitCommentaire(String appUrl, Integer siteId, String principalName, String content){

        Optional<Site> site = siteRepository.findById(siteId);
        if (!site.isPresent()){
            log.error("Aucun site n'existe avec cet id: " + siteId);
            return "Aucun site n'existe avec cet id: " + siteId;
        }

        Optional<User> user = userRepository.findByEmailIgnoreCase(principalName);
        if (!user.isPresent()){
            log.error("Aucun utilisateur ce correspond à cet email: " + principalName);
            return "Aucun utilisateur ne correspond à cet email: " + principalName;
        }

        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(content);
        commentaire.setAuteur(user.get());
        commentaire.setCreationDate(LocalDateTime.now());

        Commentaire savedCommentaire = commentaireRepository.save(commentaire);

        SiteDescription siteDescription = site.get().getDetail();
        siteDescription.setId(site.get().getDetail().getId());
        siteDescription.addCommentaire(savedCommentaire);

        siteDescriptionRepository.save(siteDescription);
        ApplicationEvent event = new OnCommentAddedEvent(this, appUrl, savedCommentaire, user.get());
        eventPublisher.publishEvent(event);
        return null;
    }

    public String validateCommentaire(String token){
        Optional<VerificationToken> verificationToken = tokenRepository.findById(token);
        if (!verificationToken.isPresent()){
            log.error("Jeton de vérification de commentaire invalide: " + token);
            return "Ce token n'existe pas/plus. Le commentaire associé a peut-être été déjà validé...";
        }
        Commentaire commentaire = verificationToken.get().getCommentaire();
        if (commentaire==null){
            log.error("Aucun Commentaire associé à ce jeton de vérification: " + token);
            return "Aucun commentaire associé à ce jeton";
        }
        tokenRepository.delete(verificationToken.get());
        log.debug("VerificationToken " + token + " was deleted (comment validation)");

        commentaire.setStatut(CommentaireStatut.valide);
        Commentaire updatedCommentaire = commentaireRepository.save(commentaire);
        log.debug("Le commentaire id: " + updatedCommentaire.getId() + " a désormais le statut '" + updatedCommentaire.getStatut() + "'");
        return null;
    }

}
