package sam.ocr.escalade.dto;

/**
 * DTO utilisé par une vue afin de construire les critères de recherche de topos choisis par l'utilisateur
 */
public class RechercheTopoDTO extends RechercheDTO {
    private String titre;
    private String site;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
