package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class Welcome {

    Logger logger = LoggerFactory.logger(Welcome.class);

    @RequestMapping("/")
    public String home() {
        return "index";
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
                logger.info("Details class name: " + auth.getDetails().getClass().getName());
                logger.info("Details: " + auth.getDetails() + ", Name:" + auth.getName());
                logger.info("Credentials: " + auth.getCredentials());
                logger.info("isAuthenticated: " + auth.isAuthenticated());
                logger.info("Principal class nama: " + auth.getPrincipal().getClass().getName());
            }
        }

        logger.info("------->>>>>>> renvoi vers la vue 'sample'");
        return "sample";
    }

}
