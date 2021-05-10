package rev.team.BOARD_SERVICE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rev.team.BOARD_SERVICE.domain.entity.Board;
import rev.team.BOARD_SERVICE.domain.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public ResponseEntity<Board> getPost(Long id) {
        Optional<Board> post = boardRepository.findById(id);
        if(post.isPresent()) return ResponseEntity.ok(post.get());
        else return ResponseEntity.notFound().build();
    }

    public Board save(Board board) {
        boardRepository.save(board);
        return board;
    }

    public String deletePost(Long id) {
        boardRepository.deleteById(id);
        return "OK";
    }

    @Transactional
    public String updatePost(Long id, String title) {
        boardRepository.updateById(id, title);
        return "OK";
    }
}
