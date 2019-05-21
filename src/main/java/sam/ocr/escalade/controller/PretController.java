package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sam.ocr.escalade.config.ApplicationConfig;
import sam.ocr.escalade.dto.NavDTO;
import sam.ocr.escalade.model.Topo;
import sam.ocr.escalade.service.FileStorageService;
import sam.ocr.escalade.service.PretService;
import sam.ocr.escalade.service.StorageService;

import java.security.Principal;

/**
 * Controlleur fournissant l'affichage des pages en lien avec les prêts de topo (liste des topos disponibles et ajout d'un prêt par un utilisateur)
 */
@Controller
public class PretController {

    private Logger logger = LoggerFactory.logger(PretController.class);

    private PretService pretService;

    private StorageService storageService;

    private ApplicationConfig applicationConfig;

    private TableNavigationHelper navHelper;

    @Autowired
    public PretController(PretService pretService, FileStorageService storageService, ApplicationConfig applicationConfig, TableNavigationHelper navHelper) {
        this.pretService = pretService;
        this.storageService = storageService;
        this.applicationConfig = applicationConfig;
        this.navHelper = navHelper;
    }

    @GetMapping(value = "/pret")
    public String showPrets(@RequestParam(name = "p", required = false) String pageNb, @RequestParam(required = false) String message, Principal principal, Model model) {

        int currentPage = pageNb == null ? 0 : Integer.parseInt(pageNb);
        Page<Topo> page = pretService.getTopoPrets(applicationConfig.tableSize, currentPage, principal.getName());

        NavDTO nav = null;
        if (page.getTotalPages() != 0)
            nav = navHelper.buildNavInfo(currentPage, page.getTotalPages());

        model.addAttribute("nav", nav);
        model.addAttribute("prets", page.getContent());
        model.addAttribute("message", message);
        return "pret";
    }

    @PostMapping(value = "/pret")
    public String handleFileUpload(@RequestParam String titre, @RequestParam String description, @RequestParam("file") MultipartFile file, Principal principal, RedirectAttributes redirectAttributes) {

        logger.debug("Pret d'un topo - titre: " + titre + ", description: " + description + ", file contentType: " + file.getContentType() + ", file name: " + file.getOriginalFilename()+ ", file size: " + file.getSize());

        boolean result = pretService.createTopo(titre, description, file, principal.getName());
        if (result)
            redirectAttributes.addAttribute("message", "Votre topoguide est maintenant disponible. Merci!");
        else
            redirectAttributes.addAttribute("message", "Votre topoguide n'a pas pu être enregistré. Désolé...");

        return "redirect:/pret";
    }

}
