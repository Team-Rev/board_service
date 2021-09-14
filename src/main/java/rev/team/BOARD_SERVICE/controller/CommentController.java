package rev.team.BOARD_SERVICE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rev.team.BOARD_SERVICE.domain.entity.Comment;
import rev.team.BOARD_SERVICE.service.CommentService;

import java.util.List;

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
    @GetMapping("")
    public List<Comment> getComments(@RequestParam("askId") Long askId, @RequestParam("page") Integer page){
        return commentService.getComments(askId, page);
    }

    //TODO : 수정
    //TODO : 삭제
}
