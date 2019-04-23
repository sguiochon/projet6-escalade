package sam.ocr.escalade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import sam.ocr.escalade.listener.OnCommentAddedEvent;
import sam.ocr.escalade.model.Commentaire;
import sam.ocr.escalade.model.Site;
import sam.ocr.escalade.model.SiteDescription;
import sam.ocr.escalade.model.User;
import sam.ocr.escalade.repository.CommentaireRepository;
import sam.ocr.escalade.repository.SiteDescriptionRepository;
import sam.ocr.escalade.repository.SiteRepository;
import sam.ocr.escalade.repository.UserRepository;

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
    private SiteDescriptionRepository siteDescriptionRepository;

    public boolean submitCommentaire(String appUrl, Integer siteId, String principalName, String content){

        Optional<Site> site = siteRepository.findById(siteId);
        if (!site.isPresent()){
            log.error("Invalid site (id): " + siteId);
            return false;
        }

        Optional<User> user = userRepository.findByEmailIgnoreCase(principalName);
        if (!user.isPresent()){
            log.error("Invalid user principal (email address): " + principalName);
            return false;
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
        ApplicationEvent event = new OnCommentAddedEvent(this, appUrl, 1, "Salut", user.get().getFirstName()+ " " + user.get().getLastName());
        eventPublisher.publishEvent(event);
        return true;
    }

}
