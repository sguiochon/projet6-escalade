package sam.ocr.escalade.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import sam.ocr.escalade.model.Commentaire;
import sam.ocr.escalade.model.VerificationToken;
import sam.ocr.escalade.repository.VerificationTokenRepository;
import sam.ocr.escalade.service.CommentaireService;

import java.util.Locale;
import java.util.UUID;

/**
 * Listener d'évènement généré lors de l'ajout d'un commentaire sur un site.
 * En réponse à cet évènement, un mail de validation du commentaire est envoyé à l'administrateur.
 */
@Component
public class CommentAddedListener {

    private static final Logger logger = LoggerFactory.getLogger(CommentAddedListener.class);

    private final JavaMailSender mailSender;

    private final Environment env;

    private final VerificationTokenRepository tokenRepository;

    @Autowired
    public CommentAddedListener(JavaMailSender mailSender, Environment env, VerificationTokenRepository tokenRepository) {
        this.mailSender = mailSender;
        this.env = env;
        this.tokenRepository = tokenRepository;
    }

    @Async
    @EventListener
    public void onApplicationEvent(OnCommentAddedEvent event) {

        UUID uuid = UUID.randomUUID();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(uuid.toString());
        verificationToken.setCommentaire(event.getCommentaire());

        tokenRepository.save(verificationToken);

        final SimpleMailMessage email = constructEmailMessage(event, uuid.toString());
        logger.debug("Envoi d'email: " + email);
        mailSender.send(email);
    }

    private final SimpleMailMessage constructEmailMessage(final OnCommentAddedEvent event, final String token) {
        final String recipientAddress = env.getProperty("moderator.email");
        final String subject = "VertiGO! Nouveau commentaire";
        final String confirmationUrl = event.getAppUrl() + "/commentValidation?token=" + token;
        String message = "Un commentaire vient d'être soumis par " + event.getAuteur().getFirstName() + " " + event.getAuteur().getLastName() + " (" + event.getAuteur().getEmail() + "):\r\n";
        message += event.getCommentaire().getContenu() + "\r\n";
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\nPour accepter le commentaire: " + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
