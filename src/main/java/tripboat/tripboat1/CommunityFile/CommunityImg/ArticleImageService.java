package tripboat.tripboat1.CommunityFile.CommunityImg;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tripboat.tripboat1.CommunityFile.Community;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleImageService {


    private final ArticleImageRepository articleImageRepository;

    public ArticleImageDto communityImageDto(String imgUrl, Community community) {
        Image image = Image.builder()
                .imgUrl(imgUrl)
                .article(community)
                .createDate(LocalDateTime.now())
                .build();

        Image image1 = articleImageRepository.save(image);

        ArticleImageDto dto = new ArticleImageDto(image1);

        return dto;
    }
    public void setCommunityImageArticle(Community community, List<Long> imageIdList) {
        List<Image> imageList = articleImageRepository.findByIdIn(imageIdList);

        System.out.println("게시물에 등록된 사진 개수: " + imageList.size());
        imageList
                .stream()
                .forEach(
                        communityImage -> {
                            communityImage.setArticle(community);
                            articleImageRepository.save(communityImage);
                        }
                );
    }
    public List<Image> getCommunityImageArticle(Community community) {

        return articleImageRepository.findByArticle(community);
    }

}
