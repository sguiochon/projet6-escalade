package sam.ocr.escalade.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.ListePays;
import sam.ocr.escalade.model.Site;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Integer> {

    List<Site> findByIsMisEnAvant(boolean misEnAvant);

    Page<Site> findByCotationMaxLessThanEqual(Pageable page, String before);

    Page<Site> findByNomContains(Pageable page, String contains);

    Page<Site> findByPays(Pageable page, ListePays pays);
}
