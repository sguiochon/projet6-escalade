package sam.ocr.escalade.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nom;

    @Column(columnDefinition="TEXT")
    private String description;

    private String nomRessource;

    @Enumerated(value = EnumType.STRING)
    private TopoStatut statut;

    @ManyToMany
    private List<Site> sites;
}
