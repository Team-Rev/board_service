package rev.team.BOARD_SERVICE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rev.team.BOARD_SERVICE.domain.entity.Board;
import rev.team.BOARD_SERVICE.service.BoardService;

@RestController
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Board> getPost(@PathVariable("id") Long id){
        return boardService.getPost(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Board> createPost(@RequestBody Board board){
        return ResponseEntity.ok(boardService.save(board));
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable("id") Long id){
        return boardService.deletePost(id);
    }

    @PatchMapping("/post/{id}")
    public String updatePost(@PathVariable("id") Long id, @RequestParam("title")String title){
        return boardService.updatePost(id, title);
    }
}
