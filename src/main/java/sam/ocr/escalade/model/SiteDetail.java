package sam.ocr.escalade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SiteDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descEscalade;

    private String descAcces;

    private String descMoment;

    private String descHebergement;

    private String descAutre;
}
