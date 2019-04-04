package sam.ocr.escalade.commentModeration;

import org.springframework.context.ApplicationEvent;

public class OnCommentSubmissionEvent extends ApplicationEvent {

    private Integer commentaireId;
    private String commentaireContent;
    private String auteur;

    public OnCommentSubmissionEvent(Object source, Integer commentaireId, String commentaireContent, String auteur) {
        super(source);
        this.auteur = auteur;
        this.commentaireContent = commentaireContent;
        this.commentaireId = commentaireId;
    }

    public Integer getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(Integer commentaireId) {
        this.commentaireId = commentaireId;
    }

    public String getCommentaireContent() {
        return commentaireContent;
    }

    public void setCommentaireContent(String commentaireContent) {
        this.commentaireContent = commentaireContent;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
