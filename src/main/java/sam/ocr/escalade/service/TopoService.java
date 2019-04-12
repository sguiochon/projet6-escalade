package sam.ocr.escalade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sam.ocr.escalade.config.ApplicationConfig;
import sam.ocr.escalade.model.Topo;
import sam.ocr.escalade.repository.TopoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopoService {

    private static final Logger log = LoggerFactory.getLogger(TopoService.class);

    private TopoRepository topoRepository;


    @Autowired
    public TopoService(TopoRepository topoRepository, ApplicationConfig applicationConfig) {
        this.topoRepository = topoRepository;
    }

    public Page<Topo> getTopos(int pageSize, int pageNumber, String paramTitre) {

        String titre = (paramTitre == null || paramTitre.equals("")) ? null : paramTitre;

        log.debug("### Searching 'Topo' matching : Titre=" + titre);

        PageRequest pageIn = PageRequest.of(pageNumber, pageSize);

        if (titre == null)
            return topoRepository.findAllByOrderByTitreAsc(pageIn);
        else
            return topoRepository.findByTitreContainsOrDescriptionContains(pageIn, titre, titre);

    }

    public List<String> getAllTitreAndDescription() {
        List<Topo> topos = topoRepository.findAll();
        List<String> titresAndDescriptions = new ArrayList<String>();
        for (Topo topo : topos){
            titresAndDescriptions.add(topo.getTitre());
            titresAndDescriptions.add(topo.getDescription());
        }
        return titresAndDescriptions;
    }
}
