package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sam.ocr.escalade.model.Site;
import sam.ocr.escalade.service.CommentaireService;
import sam.ocr.escalade.service.SiteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {

    Logger logger = LoggerFactory.logger(MainController.class);

    SiteService siteService;

    CommentaireService commentaireService;

    @Autowired
    public MainController(SiteService siteService, CommentaireService commentaireService){
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
    public String showSites(@RequestParam(name="p", required=false) String pageNb, @RequestParam(required=false)String pays, @RequestParam(required=false)String site, @RequestParam(required = false) String niveau, Model model){
        int iPage = pageNb==null?0:Integer.parseInt(pageNb);
        Page<Site> page = siteService.getSites(2, iPage, pays, site, niveau);
        model.addAttribute("sites", page.getContent());
        model.addAttribute("currentPage", iPage);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listePays", pays);
        return "sites";
    }

    @RequestMapping("/site")
    public String showSite(@RequestParam Integer id, Model model){
        Optional<Site> result = siteService.getSite(id);
        model.addAttribute("site", result.get());
        return "site";
    }

    @RequestMapping(value = "/commentaire/{siteId}", method = POST)
    public String saveCommentaire(@PathVariable("siteId") String siteId, @RequestParam(name="contenu", required = false) String contenu, RedirectAttributes redirectAttributes, Principal principal){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> site id: " + siteId);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> contenu: " + contenu);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> principal: " + principal.getClass().getName());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> principal name: " + principal.getName());

        commentaireService.submitCommentaire(Integer.parseInt(siteId), principal.getName(), contenu);

        redirectAttributes.addAttribute("id", siteId);
        return "redirect:/site";
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
        }

        logger.info("------->>>>>>> renvoi vers la vue 'sample'");
        return "sample";
    }

}
