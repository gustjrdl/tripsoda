package tripboat.tripboat1.CommunityFile;

import lombok.*;
import tripboat.tripboat1.CommentFile.Comment;
import tripboat.tripboat1.CommunityFile.CommunityImg.ArticleImageDto;
import tripboat.tripboat1.CommunityFile.CommunityImg.Image;
import tripboat.tripboat1.User.SiteUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3000)
    @NotNull
    private String content;

    private String subject;

    @Column(length = 20)
    private String region;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "community", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    private LocalDateTime modifyDate;

    @ManyToOne
    private SiteUser author;

    @OneToMany(mappedBy = "article")
    private List<Image> images;


}