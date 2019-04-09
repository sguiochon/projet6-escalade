package sam.ocr.escalade.dto;

public class RechercheSiteDTO {

    private String pays;
    private String niveau;
    private String site;
    private String pageNb;

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

    public String getPageNb() {
        return pageNb;
    }

    public void setPageNb(String pageNb) {
        this.pageNb = pageNb;
    }
}
