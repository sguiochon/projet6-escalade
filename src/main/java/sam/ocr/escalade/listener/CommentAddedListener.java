package sam.ocr.escalade.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import sam.ocr.escalade.model.Commentaire;
import sam.ocr.escalade.model.VerificationToken;
import sam.ocr.escalade.repository.VerificationTokenRepository;

import java.util.Locale;
import java.util.UUID;

@Component
public class CommentAddedListener implements ApplicationListener<OnCommentAddedEvent> {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Override
    public void onApplicationEvent(OnCommentAddedEvent event) {

        UUID uuid = UUID.randomUUID();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(uuid.toString());
        verificationToken.setCommentaire(event.getCommentaire());

        tokenRepository.save(verificationToken);

        final SimpleMailMessage email = constructEmailMessage(event, uuid.toString());
        mailSender.send(email);
    }

    private final SimpleMailMessage constructEmailMessage(final OnCommentAddedEvent event, final String token) {
        final String recipientAddress = env.getProperty("moderator.email");
        final String subject = "VertiGO! Nouveau commentaire";
        final String confirmationUrl = event.getAppUrl() + "/commentValidation?token=" + token;
        String message = "Un commentaire vient d'être soumis par " + event.getAuteur().getFirstName() + " " + event.getAuteur().getLastName() + " (" + event.getAuteur().getEmail() + "):\r\n";
        message += event.getCommentaire().getContenu() + "\r\n";
        //messages.getMessage("message.regSucc", null, Locale.FRANCE);
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\nPour accepter le commentaire: " + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
