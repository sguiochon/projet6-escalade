package sam.ocr.escalade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sam.ocr.escalade.model.Site;
import sam.ocr.escalade.model.SiteDescription;
import sam.ocr.escalade.repository.SiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {

    private static final Logger log = LoggerFactory.getLogger(SiteService.class);

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

        String pays = (paramPays==null||paramPays.equals(""))?null:paramPays;
        String niveau = paramNiveau==null?null:processParamNiveau(paramNiveau);
        String site = (paramSite==null||paramSite.equals(""))?null:paramSite;

        log.debug("### Searching 'Site' matching : Pays=" + pays + ", niveau="+niveau + ", Site=" + site);

        PageRequest pageIn = PageRequest.of(pageNumber, pageSize);

        if (pays!=null && site==null && niveau==null){
            return siteRepository.findByPays(pageIn, pays);
        }

        if (pays==null && site==null && niveau!=null){
            return siteRepository.findByCotationMaxLessThanEqual(pageIn, niveau);
        }

        if (pays==null && site!=null && niveau==null){
            return siteRepository.findByNomContains(pageIn, site);
        }

//todo: ajouter les recherches combinées....

        Page<Site> pageOut = siteRepository.findAll(pageIn);
        return pageOut;
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
