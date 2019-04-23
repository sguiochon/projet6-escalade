package sam.ocr.escalade.listener;

import org.springframework.context.ApplicationEvent;
import sam.ocr.escalade.model.Commentaire;
import sam.ocr.escalade.model.User;

public class OnCommentAddedEvent extends ApplicationEvent {

    private Commentaire commentaire;
    private User auteur;
    private String appUrl;

    public OnCommentAddedEvent(Object source, String appUrl, Commentaire commentaire, User auteur) {
        super(source);
        this.appUrl = appUrl;
        this.auteur = auteur;
        this.commentaire = commentaire;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public User getAuteur() {
        return auteur;
    }


}
