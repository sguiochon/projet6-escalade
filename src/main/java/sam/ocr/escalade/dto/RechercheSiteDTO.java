package sam.ocr.escalade.dto;

/**
 * DTO utilisé par une vue afin de construire les critères de recherche de site choisis par l'utilisateur
 */
public class RechercheSiteDTO extends RechercheDTO{

    private String pays;
    private String niveau;
    private String site;


    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
