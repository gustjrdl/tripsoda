package tripboat.tripboat1.CommunityFile.CommunityImg;

import lombok.Getter;
import lombok.Setter;
import tripboat.tripboat1.CommunityFile.Community;
import tripboat.tripboat1.CommunityFile.CommunityDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class ArticleImageDto {
    private Long id;

    private String imgUrl;

    private LocalDateTime createDate;

    private Community community;

    public ArticleImageDto(Image articleImage) {
        this.id = articleImage.getId();
        this.imgUrl = articleImage.getImgUrl();
        this.createDate = articleImage.getCreateDate();
        this.community = articleImage.getArticle();
    }

}
