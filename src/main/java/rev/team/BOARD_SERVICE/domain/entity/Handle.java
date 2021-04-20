package rev.team.BOARD_SERVICE.domain.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Handle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 처리 아이디

    private Long boardId; //게시글 아이디

    private Boolean isHandle; // 처리 여부

    private LocalDateTime handleAt; //  처리 날

}
