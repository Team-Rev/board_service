package rev.team.BOARD_SERVICE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rev.team.BOARD_SERVICE.domain.entity.Comment;
import rev.team.BOARD_SERVICE.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    //TODO : 작성
    @PostMapping("")
    public ResponseEntity<Comment> create(@RequestBody Comment comment){
        Comment newComment = commentService.create(comment);
        return new ResponseEntity<>(newComment, HttpStatus.OK);
    }

    //TODO : 조회(무한로딩 해야됨)
    //TODO : 수정
    //TODO : 삭제
}
