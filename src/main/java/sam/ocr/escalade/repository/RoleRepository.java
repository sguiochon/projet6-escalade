package sam.ocr.escalade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

    @Override
    void delete(Role role);

}
