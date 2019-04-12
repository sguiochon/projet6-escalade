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

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SiteController extends TableNavigationHelper{

    private Logger logger = LoggerFactory.logger(SiteController.class);

    private SiteService siteService;

    private CommentaireService commentaireService;


    @Autowired
    public SiteController(SiteService siteService, CommentaireService commentaireService, ApplicationConfig applicationConfig) {
        super(applicationConfig);
        this.siteService = siteService;
        this.commentaireService = commentaireService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Site> sites = siteService.getSitesMisEnAvant();
        logger.debug("Nb de sites 'mis en avant': " + sites.size());
        model.addAttribute("sites", sites);
        return "accueil";
    }

    @RequestMapping("/sites")
    public String showSites(@RequestParam(name = "p", required = false) String pageNb, @RequestParam(required = false) String pays, @RequestParam(required = false) String site, @RequestParam(required = false) String niveau, Model model) {
        logger.debug(">>>>>>>>>>>>>>>>> Param recus >>>>>>>>>>>>>>>>>> PageCourante: " + pageNb + ", pays:" + pays + ", niveau:" + niveau + ", site:" + site);

        int currentPage = pageNb == null ? 0 : Integer.parseInt(pageNb);
        Page<Site> page = siteService.getSites(applicationConfig.tableSize, currentPage, pays, site, niveau);

        RechercheSiteDTO recherche = new RechercheSiteDTO();
        recherche.setNiveau(niveau == null ? "0" : niveau);
        recherche.setPageNb(pageNb);
        recherche.setPays(pays);
        recherche.setSite(site);

        NavDTO nav = null;
        if (page.getTotalPages() != 0)
            nav = buildNavInfo(currentPage, page.getTotalPages());

        model.addAttribute("nav", nav);
        model.addAttribute("recherche", recherche);
        model.addAttribute("sites", page.getContent());
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PageCourante: " + currentPage + ", totalPage: " + page.getTotalPages() + ", pays:" + pays + ", niveau:" + niveau + ", site:" + site);
        return "sites";
    }

    @RequestMapping("/site")
    public String showSite(@RequestParam Integer id, Model model) {
        Optional<Site> result = siteService.getSite(id);
        model.addAttribute("site", result.get());
        return "site";
    }

    @RequestMapping(value = "/commentaire/{siteId}", method = POST)
    public String saveCommentaire(@PathVariable("siteId") String siteId, @RequestParam(name = "contenu", required = false) String contenu, RedirectAttributes redirectAttributes, Principal principal) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> site id: " + siteId);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> contenu: " + contenu);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> principal: " + principal.getClass().getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> principal name: " + principal.getName());

        commentaireService.submitCommentaire(Integer.parseInt(siteId), principal.getName(), contenu);

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

    /*
    @RequestMapping("/sample")
    public String showForm(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            logger.info("Found in session: " + name);
            if ("SPRING_SECURITY_CONTEXT".equals(name)){
                SecurityContext ctx=(SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
                Authentication auth=ctx.getAuthentication();
                WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
                logger.info("Details: " + details.toString());
                logger.info("Name:" + auth.getName());
                logger.info("Authorities: " + auth.getAuthorities());
                logger.info("Credentials: " + auth.getCredentials());
                logger.info("isAuthenticated: " + auth.isAuthenticated());
                UserDetails user = (UserDetails) auth.getPrincipal();
                logger.info("User: " + user.getUsername() + ", " + user.getPassword() + ", " + user.isEnabled());
            }
        };
        return "sample";
    }*/



}
