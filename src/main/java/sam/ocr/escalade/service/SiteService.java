package sam.ocr.escalade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sam.ocr.escalade.model.ListePays;
import sam.ocr.escalade.model.Site;
import sam.ocr.escalade.model.SiteDescription;
import sam.ocr.escalade.repository.SiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository){
        this.siteRepository = siteRepository;
    }

    public List<Site> getSitesMisEnAvant(){
        return siteRepository.findByIsMisEnAvant(true);
    }

    public Optional<Site> getSite(Integer id){
        Optional<Site> result = siteRepository.findById(id);
        SiteDescription detail = result.get().getDetail();
        if (detail!=null){
            detail.getCommentaires();
        }
        return result;
    }

    public Page<Site> getSites(int pageSize, int pageNumber, String paramPays, String paramSite, String paramNiveau){

        ListePays listePays = paramPays==null?null:processParamPays(paramPays);
        String niveau = paramNiveau==null?null:processParamNiveau(paramNiveau);
        String site = (paramSite==null||paramSite.equals(""))?null:paramSite;

        PageRequest pageIn = PageRequest.of(pageNumber, pageSize);

        if (listePays!=null && site==null && niveau==null){
            return siteRepository.findByPays(pageIn, listePays);
        }

        if (listePays==null && site==null && niveau!=null){
            return siteRepository.findByCotationMaxLessThanEqual(pageIn, niveau);
        }

        if (listePays==null && site!=null && niveau==null){
            return siteRepository.findByNomContains(pageIn, site);
        }

//todo: ajouter les recherches combinées....

        Page<Site> pageOut = siteRepository.findAll(pageIn);
        return pageOut;
    }

    private ListePays processParamPays(String paramPays){
        ListePays listePays = null;
        try {
            listePays = ListePays.valueOf(paramPays);
        } catch (IllegalArgumentException e) {
            // valeur du champ 'pays' invalide donc ignorée...
        }
        return listePays;
    }

    private String processParamNiveau(String paramNiveau) {
        switch (paramNiveau) {
            case "1":
                return "5b";
            case "2":
                return "6a";
            case "3":
                return "7a";
            case "4":
                return "9b";
            default:
                return null;
        }
    }

}
