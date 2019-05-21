package sam.ocr.escalade.dto;

/**
 * DTO contenant l'information commmune à RechercheSiteDTO et RechercheTopoDTO
 */
public abstract class RechercheDTO {

    private String pageNb;

    public String getPageNb() {
        return pageNb;
    }

    public void setPageNb(String pageNb) {
        this.pageNb = pageNb;
    }

}
