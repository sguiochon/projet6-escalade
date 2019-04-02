package sam.ocr.escalade.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NotNull(message = "Le champ 'nom' ne peut pas être vide.")
    private String nom;
    @NotNull(message = "le champ 'description' ne peut pas être vide.")
    private String description;
    @Enumerated(value = EnumType.STRING)
    private ListePays pays;
    private Integer hauteur;
    private String cotationMin;
    private String cotationMax;
    private String nbDeVoies;
    private String orientation;
    private String imageUrl;
    private boolean isMisEnAvant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ListePays getPays() {
        return pays;
    }

    public void setPays(ListePays pays) {
        this.pays = pays;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public String getCotationMin() {
        return cotationMin;
    }

    public void setCotationMin(String cotationMin) {
        this.cotationMin = cotationMin;
    }

    public String getCotationMax() {
        return cotationMax;
    }

    public void setCotationMax(String cotationMax) {
        this.cotationMax = cotationMax;
    }

    public String getNbDeVoies() {
        return nbDeVoies;
    }

    public void setNbDeVoies(String nbDeVoies) {
        this.nbDeVoies = nbDeVoies;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isMisEnAvant() {
        return isMisEnAvant;
    }

    public void setMisEnAvant(boolean misEnAvant) {
        isMisEnAvant = misEnAvant;
    }

}
