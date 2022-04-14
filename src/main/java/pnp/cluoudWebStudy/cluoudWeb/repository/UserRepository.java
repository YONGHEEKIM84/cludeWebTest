package pnp.cluoudWebStudy.cluoudWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pnp.cluoudWebStudy.cluoudWeb.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
