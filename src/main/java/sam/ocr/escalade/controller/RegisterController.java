package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sam.ocr.escalade.service.UserRegistrationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Contrôleur traitant la demande de création d'un compte utilisateur (affichage de la page et traitement du formulaire soumis).
 */
@Controller
public class RegisterController {

    private Logger logger = LoggerFactory.logger(PretController.class);

    @Autowired
    UserRegistrationService userRegistrationService;

    @GetMapping("/register")
    public String showForm(){
        return "register";
    }

    @PostMapping("/register")
    public String submitRegistration(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password, HttpServletRequest request){
        logger.debug("Enregistrement nouveau membre - prenom: " + firstname + ", nom: " + lastname + ", email: " + email + ", password: " + password);

        final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

        Optional<String> errorMessage = userRegistrationService.submitRegistration(appUrl, firstname, lastname, email, password);

        return "redirect:/";
    }

}
