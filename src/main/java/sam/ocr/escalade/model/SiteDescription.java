package sam.ocr.escalade.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SiteDescription {
    @Id
    @GeneratedValue
    private Integer id;

    private String titre1;
    @Column(columnDefinition = "TEXT")
    private String contenu1;
    private String titre2;
    @Column(columnDefinition = "TEXT")
    private String contenu2;
    private String titre3;
    @Column(columnDefinition = "TEXT")
    private String contenu3;
    @OneToMany
    private List<Commentaire> commentaires;

    public String getTitre1() {
        return titre1;
    }

    public void setTitre1(String titre1) {
        this.titre1 = titre1;
    }

    public String getContenu1() {
        return contenu1;
    }

    public void setContenu1(String contenu1) {
        this.contenu1 = contenu1;
    }

    public String getTitre2() {
        return titre2;
    }

    public void setTitre2(String titre2) {
        this.titre2 = titre2;
    }

    public String getContenu2() {
        return contenu2;
    }

    public void setContenu2(String contenu2) {
        this.contenu2 = contenu2;
    }

    public String getTitre3() {
        return titre3;
    }

    public void setTitre3(String titre3) {
        this.titre3 = titre3;
    }

    public String getContenu3() {
        return contenu3;
    }

    public void setContenu3(String contenu3) {
        this.contenu3 = contenu3;
    }

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

    public void addCommentaire(Commentaire commentaire) {
        if (commentaires == null)
            commentaires = new ArrayList<Commentaire>();
        commentaires.add(commentaire);
    }
}
