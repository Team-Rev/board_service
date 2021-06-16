package rev.team.BOARD_SERVICE.service;

import org.springframework.stereotype.Service;
import rev.team.BOARD_SERVICE.domain.entity.Comment;
import rev.team.BOARD_SERVICE.domain.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment create(Comment comment) {
        comment.setCommentId(commentRepository.count()+1);
        if(comment.getRefComment() == null) comment.setRefComment(comment.getCommentId());
        return commentRepository.save(comment);
    }
}
