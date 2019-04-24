package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sam.ocr.escalade.service.UserRegistrationService;

import java.util.Optional;

@Controller
public class ConfirmRegistrationController {

    private Logger logger = LoggerFactory.logger(ConfirmRegistrationController.class);

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping("/confirmRegistration")
    public String validate(@RequestParam String token, RedirectAttributes redirectAttributes) {
        logger.debug("Confirmation ajout nouveau membre. Token: " + token);

        Optional<String> errorMessage = userRegistrationService.confirmRegistration(token);
        if (errorMessage.isPresent()) {
            redirectAttributes.addAttribute("error", errorMessage.get());
        }
        else {
            redirectAttributes.addAttribute("message", "bienvenue");
        }
        return "redirect:/";
    }
}
