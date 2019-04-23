package sam.ocr.escalade.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CommentAddedListener implements ApplicationListener<OnCommentAddedEvent> {

    @Autowired
    private JavaMailSender mailSender;

    //@Autowired
    //private MessageSource messages;

    @Override
    public void onApplicationEvent(OnCommentAddedEvent event) {
        System.out.println("########################################## Commentaire soumis!!!! #################");
        String token = "1234";
        final SimpleMailMessage email = constructEmailMessage(event, token);
        mailSender.send(email);
    }

    private final SimpleMailMessage constructEmailMessage(final OnCommentAddedEvent event, final String token) {
        final String recipientAddress = "fragozozo@gmail.com";
        final String subject = "VertiGO! Nouveau commentaire";
        final String confirmationUrl = event.getAppUrl() + "/commentValidation?token=" + token;
        final String message = "Un commentaire vient d'être soumis. ";//messages.getMessage("message.regSucc", null, Locale.FRANCE);
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        email.setFrom("fragozozo@gmail.com");
        return email;
    }
}
