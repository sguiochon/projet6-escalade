package sam.ocr.escalade.dto;

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
