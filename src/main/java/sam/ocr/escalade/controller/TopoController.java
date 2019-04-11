package sam.ocr.escalade.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class TopoController {

    Logger logger = LoggerFactory.logger(TopoController.class);


    public String showTopos(){


      return "topos";
    }

}
