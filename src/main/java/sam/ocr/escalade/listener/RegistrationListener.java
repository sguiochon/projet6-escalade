package sam.ocr.escalade.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import sam.ocr.escalade.model.VerificationToken;
import sam.ocr.escalade.repository.VerificationTokenRepository;

import java.util.UUID;

/**
 * Listener d'évènement généré lors de la création d'un compte utilisateur.
 * En réponse à cet évènement, un mail de confirmation est envoyé à l'utilisateur permettant d'activer le compte temporaire créé.
 */
@Component
public class RegistrationListener{

    private static final Logger logger = LoggerFactory.getLogger(RegistrationListener.class);

    private final JavaMailSender mailSender;

    private final Environment env;

    private final VerificationTokenRepository tokenRepository;

    @Autowired
    public RegistrationListener(JavaMailSender mailSender, Environment env, VerificationTokenRepository tokenRepository) {
        this.mailSender = mailSender;
        this.env = env;
        this.tokenRepository = tokenRepository;
    }

    @Async
    @EventListener
    public void onApplicationEvent(OnRegistrationEvent event) {
        UUID uuid = UUID.randomUUID();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(uuid.toString());
        verificationToken.setUser(event.getUser());

        tokenRepository.save(verificationToken);

        final SimpleMailMessage email = constructEmailMessage(event, uuid.toString());
        mailSender.send(email);
    }

    private final SimpleMailMessage constructEmailMessage(final OnRegistrationEvent event, final String token) {
        final String recipientAddress = event.getUser().getEmail();
        final String subject = "VertiGO! Finalisez votre inscription...";
        final String confirmationUrl = event.getAppUrl() + "/confirmRegistration?token=" + token;

        String message = "Pour finaliser votre inscription sur le site VertiGO!, cliquez sur le lien ci-dessous: \r\n";

        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));

        logger.debug("Lien de confirmation d'inscription: " + confirmationUrl);

        return email;
    }
}
