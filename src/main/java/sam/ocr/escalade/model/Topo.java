package sam.ocr.escalade.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String nomRessource;
    @Enumerated(value = EnumType.STRING)
    private TopoStatut statut;
    @ManyToOne
    private User preteur;
    @ManyToMany
    private List<Site> sites;

    private String image1;

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomRessource() {
        return nomRessource;
    }

    public void setNomRessource(String nomRessource) {
        this.nomRessource = nomRessource;
    }

    public TopoStatut getStatut() {
        return statut;
    }

    public void setStatut(TopoStatut statut) {
        this.statut = statut;
    }

    public User getPreteur() {
        return preteur;
    }

    public void setPreteur(User preteur) {
        this.preteur = preteur;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
