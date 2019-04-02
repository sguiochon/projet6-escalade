package sam.ocr.escalade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(String email);

    @Override
    void delete(User user);

}

