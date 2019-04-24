package sam.ocr.escalade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sam.ocr.escalade.exception.DatabaseException;
import sam.ocr.escalade.listener.OnCommentAddedEvent;
import sam.ocr.escalade.listener.OnRegistrationEvent;
import sam.ocr.escalade.model.*;
import sam.ocr.escalade.repository.RoleRepository;
import sam.ocr.escalade.repository.UserRepository;
import sam.ocr.escalade.repository.VerificationTokenRepository;

import java.util.Optional;

@Service
public class UserRegistrationService {

    private static final Logger log = LoggerFactory.getLogger(UserRegistrationService.class);

    private final static String DEFAULT_ROLE = "visiteur";

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    public PasswordEncoder encoder;

    public Optional<String> submitRegistration(String appUrl, String firstname, String lastname, String email, String password) {

        // Verification que l'email n'est pas déjà enregistré

        Optional<User> existingUser = userRepository.findByEmailIgnoreCase(email);
        if (existingUser.isPresent()){
            log.debug("Tentative de création d'un membre avec un email déjà enregistré: " + email);
            return Optional.of("Un compte existe déjà avec cette adresse email");
        }

        Optional<Role> role = roleRepository.findByName(DEFAULT_ROLE);
        if (!role.isPresent()){
            throw new DatabaseException("Role " + DEFAULT_ROLE + " n'existe pas dans la base. Le script de création de la BdD est incorrect.");
        }

        User user = new User(firstname, lastname, email, encoder.encode(password));
        user.addRole(role.get());
        User newUser = userRepository.save(user);

        ApplicationEvent event = new OnRegistrationEvent(newUser, appUrl);
        eventPublisher.publishEvent(event);

        return Optional.empty();
    }

    public Optional<String> confirmRegistration(String token) {
        Optional<VerificationToken> verificationToken = tokenRepository.findById(token);
        if (!verificationToken.isPresent()){
            log.error("Jeton de vérification de commentaire invalide: " + token);
            return Optional.of("Ce token n'existe pas/plus. La confirmation de création de compte a peut-être été déjà traitée...");
        }
        User user = verificationToken.get().getUser();
        if (user==null){
            log.error("Aucun User associé à ce jeton de vérification: " + token);
            return Optional.of("Aucune demande de création de compte n'est associée à ce jeton");
        }
        tokenRepository.delete(verificationToken.get());
        log.debug("VerificationToken " + token + " was deleted (comment validation)");

        user.setEnabled(true);
        User updatedUser = userRepository.save(user);
        log.debug("Le membre " + updatedUser.getFirstName() + " " + updatedUser.getLastName() + " (" + updatedUser.getEmail() + ") est désormais actif.");

        return Optional.empty();
    }
}
