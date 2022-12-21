package tripboat.tripboat1.CommentFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tripboat.tripboat1.CommunityFile.Community;
import tripboat.tripboat1.User.SiteUser;
import tripboat.tripboat1.Util.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void create(Community community, String content, SiteUser author) {
        Comment cmt = new Comment();
        cmt.setContent(content);
        cmt.setCreateDate(LocalDateTime.now());
        cmt.setCommunity(community);
        cmt.setAuthor(author);
        this.commentRepository.save(cmt);
    }
    public Comment getComment(Integer id) {
        Optional<Comment> comment = this.commentRepository.findById(id);
        if (comment.isPresent()) {
            return comment.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }

    public void modify(Comment answer, String content) {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.commentRepository.save(answer);
    }

    public void delete(Comment comment) {
        this.commentRepository.delete(comment);
    }

}
