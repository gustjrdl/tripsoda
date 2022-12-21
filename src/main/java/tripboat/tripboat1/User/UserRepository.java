package tripboat.tripboat1.User;

import org.springframework.data.jpa.repository.JpaRepository;
import tripboat.tripboat1.User.SiteUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);


}