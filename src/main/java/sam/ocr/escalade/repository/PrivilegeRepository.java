package sam.ocr.escalade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
