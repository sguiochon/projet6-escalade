package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sam.ocr.escalade.config.ApplicationConfig;
import sam.ocr.escalade.dto.NavDTO;
import sam.ocr.escalade.dto.RechercheSiteDTO;
import sam.ocr.escalade.model.Site;
import sam.ocr.escalade.service.CommentaireService;
import sam.ocr.escalade.service.SiteService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Contrôleur gérant l'affichage de la page présentant la liste des sites 'mis en avant', la liste des sites disponibles, la description détaillée d'un site, la soumission d'un commentaire.
 */
@Controller
public class SiteController {

    private Logger logger = LoggerFactory.logger(SiteController.class);

    private SiteService siteService;

    private CommentaireService commentaireService;

    private ApplicationConfig applicationConfig;

    private TableNavigationHelper navHelper;

    @Autowired
    public SiteController(SiteService siteService, CommentaireService commentaireService, ApplicationConfig applicationConfig, TableNavigationHelper navHelper) {
        this.siteService = siteService;
        this.commentaireService = commentaireService;
        this.applicationConfig = applicationConfig;
        this.navHelper = navHelper;
    }

    @RequestMapping("/")
    public String home(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String message) {
        List<Site> sites = siteService.getSitesMisEnAvant();
        model.addAttribute("sites", sites);
        logger.debug("error message: " + error + ", message: " + message);
        if (error!=null)
            model.addAttribute("error", error);
        if (message!=null)
            model.addAttribute("message", message);
        return "accueil";
    }

    @RequestMapping("/sites")
    public String showSites(@RequestParam(name = "p", required = false) String pageNb, @RequestParam(required = false) String pays, @RequestParam(required = false) String site, @RequestParam(required = false) String niveau, Model model) {
        int currentPage = pageNb == null ? 0 : Integer.parseInt(pageNb);
        Page<Site> page = siteService.getSites(applicationConfig.tableSize, currentPage, pays, site, niveau);

        RechercheSiteDTO recherche = new RechercheSiteDTO();
        recherche.setNiveau(niveau == null ? "0" : niveau);
        recherche.setPageNb(pageNb);
        recherche.setPays(pays);
        recherche.setSite(site);

        NavDTO nav = null;
        if (page.getTotalPages() != 0)
            nav = navHelper.buildNavInfo(currentPage, page.getTotalPages());

        model.addAttribute("nav", nav);
        model.addAttribute("recherche", recherche);
        model.addAttribute("sites", page.getContent());
        return "sites";
    }

    @RequestMapping("/site")
    public String showSite(@RequestParam Integer id, Model model) {
        Optional<Site> result = siteService.getSite(id);
        model.addAttribute("site", result.get());
        return "site";
    }

    @RequestMapping(value = "/commentaire/{siteId}", method = POST)
    public String saveCommentaire(@PathVariable("siteId") String siteId, @RequestParam(name = "contenu", required = false) String contenu, RedirectAttributes redirectAttributes, Principal principal, HttpServletRequest request) {

        final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        Optional<String> errorMessage = commentaireService.submitCommentaire(appUrl, Integer.parseInt(siteId), principal.getName(), contenu);
        //todo : voir si le message d'erreur doit etre remonté sur le brwoser...

        redirectAttributes.addAttribute("id", siteId);
        return "redirect:/site?#commentaire";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
