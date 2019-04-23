package sam.ocr.escalade.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.Commentaire;
import sam.ocr.escalade.model.CommentaireStatut;

import java.util.List;
import java.util.Optional;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

    @Override
    @EntityGraph(value = "Commentaire.detail", type = EntityGraph.EntityGraphType.LOAD)
    public Optional<Commentaire> findById(Integer Id);


}
