package sam.ocr.escalade.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedEntityGraph(name = "Commentaire.detail", attributeNodes = @NamedAttributeNode("auteur"))
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private User auteur;
    private Date creationDate;
    private String contenu;
    @Enumerated(value = EnumType.STRING)
    private CommentaireStatut statut = CommentaireStatut.soumis;

    public CommentaireStatut getStatut() {
        return statut;
    }

    public void setStatut(CommentaireStatut statut) {
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuteur() {
        return auteur;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
