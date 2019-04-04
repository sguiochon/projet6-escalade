package sam.ocr.escalade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SiteDescription {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<Commentaire> commentaires;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public void addCommentaire(Commentaire commentaire){
        if (commentaires==null)
            commentaires = new ArrayList<Commentaire>();
        commentaires.add(commentaire);
    }
}
