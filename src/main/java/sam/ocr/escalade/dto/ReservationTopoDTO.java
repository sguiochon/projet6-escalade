package sam.ocr.escalade.dto;

/**
 * DTO construit par désérialisation de JSON généré par le browser pour invoquer une ressource de TopoController (reserverTopo)
 */
public class ReservationTopoDTO {

    private Integer id;
    private Integer duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
