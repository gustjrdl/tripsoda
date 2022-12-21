package tripboat.tripboat1.CommunityFile;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface CommunityRepository extends JpaRepository<Community, Integer> {


    Page<Community> findAll(Pageable pageable);
    Page<Community> findAll(Specification<Community> spec, org.springframework.data.domain.Pageable pageable);
}
