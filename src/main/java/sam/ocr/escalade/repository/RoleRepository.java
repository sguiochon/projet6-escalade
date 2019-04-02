package sam.ocr.escalade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
