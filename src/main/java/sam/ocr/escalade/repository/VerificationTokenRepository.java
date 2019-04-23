package sam.ocr.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, String> {


}
