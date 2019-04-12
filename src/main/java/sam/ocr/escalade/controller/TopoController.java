package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sam.ocr.escalade.config.ApplicationConfig;
import sam.ocr.escalade.dto.NavDTO;
import sam.ocr.escalade.dto.RechercheTopoDTO;
import sam.ocr.escalade.model.Topo;
import sam.ocr.escalade.service.TopoService;

@Controller
public class TopoController extends TableNavigationHelper{

    Logger logger = LoggerFactory.logger(TopoController.class);

    private TopoService topoService;


    @Autowired
    public TopoController(TopoService topoService, ApplicationConfig applicationConfig) {
        super(applicationConfig);
        this.topoService = topoService;
    }

    @RequestMapping("/topos")
    public String showTopos(@RequestParam(name = "p", required = false) String pageNb, @RequestParam(name="titre", required = false) String titre, Model model) {
        int currentPage = pageNb == null ? 0 : Integer.parseInt(pageNb);
        Page<Topo> page = topoService.getTopos(applicationConfig.tableSize, currentPage, titre);

        RechercheTopoDTO recherche = new RechercheTopoDTO();
        recherche.setTitre(titre);
        recherche.setSite("");
        recherche.setPageNb(pageNb);

        NavDTO nav = null;
        if (page.getTotalPages() != 0)
            nav = buildNavInfo(currentPage, page.getTotalPages());

        model.addAttribute("nav", nav);
        model.addAttribute("recherche", recherche);
        model.addAttribute("topos", page.getContent());
        return "topos";
    }

}
