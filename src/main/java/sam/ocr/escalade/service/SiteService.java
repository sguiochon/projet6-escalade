package sam.ocr.escalade.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sam.ocr.escalade.model.ListePays;
import sam.ocr.escalade.model.Site;
import sam.ocr.escalade.repository.SiteRepository;

import java.util.Collection;
import java.util.List;

@Service
public class SiteService {

    private SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository){
        this.siteRepository = siteRepository;
    }

    public List<Site> getSitesMisEnAvant(){
        return siteRepository.findByIsMisEnAvant(true);
    }

    public Page<Site> getSites(int pageSize, int pageNumber, String pays, String site){

        ListePays listePays = null;

        try {
            listePays = ListePays.valueOf(pays);
        } catch (IllegalArgumentException e) {
            // valeur du champ 'pays' invalide donc ignorée...
        } catch (NullPointerException e) {
            // champ 'pays' non spécifié donc ignoré...
        }

        System.out.println("##############>>>>>>>>>>>>>>>> Pays:  " + listePays);
        System.out.println("##############>>>>>>>>>>>>>>>> Site:  " + site);

        PageRequest pageIn = PageRequest.of(pageNumber, pageSize);
        Page<Site> pageOut = siteRepository.findAll(pageIn);
        return pageOut;
    }

}
