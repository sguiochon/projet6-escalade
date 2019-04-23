package sam.ocr.escalade.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

/**
 * VerificationToken to be used whether to validate a 'Commentaire' or a user registration.
 * Depending on which case is applies to, the VerificationToken is linked to the corresponding object (Commentaire or User)
 */
@Entity
public class VerificationToken {

    @Id
    private String token;
    private LocalDateTime expiryDate;
    @ManyToOne
    private User user;
    @OneToOne
    private Commentaire commentaire;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }
}
