package sam.ocr.escalade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sam.ocr.escalade.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailIgnoreCase(String email);

    @Override
    void delete(User user);

}

