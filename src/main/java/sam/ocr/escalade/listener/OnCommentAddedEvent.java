package sam.ocr.escalade.listener;

import org.springframework.context.ApplicationEvent;

public class OnCommentAddedEvent extends ApplicationEvent {

    private Integer commentaireId;
    private String commentaireContent;
    private String auteur;
    private String appUrl;

    public OnCommentAddedEvent(Object source, String appUrl, Integer commentaireId, String commentaireContent, String auteur) {
        super(source);
        this.appUrl = appUrl;
        this.auteur = auteur;
        this.commentaireContent = commentaireContent;
        this.commentaireId = commentaireId;
    }

    public Integer getCommentaireId() {
        return commentaireId;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public String getCommentaireContent() {
        return commentaireContent;
    }


    public String getAuteur() {
        return auteur;
    }


}
