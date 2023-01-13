package tripboat.tripboat1.CommunityFile.CommunityImg;

import lombok.*;
import tripboat.tripboat1.CommunityFile.Community;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgUrl;

    private LocalDateTime createDate;

    @ManyToOne
    private Community article;


}

