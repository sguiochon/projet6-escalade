package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sam.ocr.escalade.service.CommentaireService;

@Controller
public class CommentaireValidationController {

    private Logger logger = LoggerFactory.logger(CommentaireValidationController.class);

    @Autowired
    CommentaireService commentaireService;

    @GetMapping("/commentValidation")
    public String validate(@RequestParam String token, Model model) {
        logger.debug("Demande de validation d'un commentaire. Token: " + token);

        String errorMessage = commentaireService.validateCommentaire(token);

        model.addAttribute("error", errorMessage);
        return "validated";
    }

}
