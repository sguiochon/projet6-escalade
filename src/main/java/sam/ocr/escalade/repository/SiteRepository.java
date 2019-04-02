package sam.ocr.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.Site;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Integer> {

    List<Site> findByIsMisEnAvant(boolean misEnAvant);
}
