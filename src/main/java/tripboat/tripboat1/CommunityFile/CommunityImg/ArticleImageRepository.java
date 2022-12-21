package tripboat.tripboat1.CommunityFile.CommunityImg;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import tripboat.tripboat1.CommunityFile.Community;

import java.util.List;

public interface ArticleImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByIdIn(List<Long> imageIdList);

    List<Image> findByArticle(Community community);

}
