package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Welcome {

    Logger logger = LoggerFactory.logger(Welcome.class);

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/sample")
    public String showForm() {
        logger.info("------->>>>>>> renvoi vers la vue 'sample'");
        return "sample";
    }

}
