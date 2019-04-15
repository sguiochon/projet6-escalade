package sam.ocr.escalade.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.Topo;

public interface TopoRepository extends JpaRepository<Topo, Integer> {

    Page<Topo> findAllByOrderByTitreAsc(Pageable page);

    Page<Topo> findByTitreContainsOrDescriptionContains(Pageable page, String titre, String description);

    Page<Topo> findDistinctBySitesNomContains(Pageable page, String siteNom);

    Page<Topo> findDistinctByTitreContainsOrDescriptionContainsAndSitesNomContains(Pageable page, String titre, String description, String site);

}
