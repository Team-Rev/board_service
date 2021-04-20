package rev.team.BOARD_SERVICE.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "board")
public class Board {

    //TODO: 전체적으로 게시판 관련된 테이블 다듬을 필요성이 있음
    //TODO: 관리자 테이블 추가적으로 다듬어야 함
    //TODO: 게시글이 공지사항도 있고 문의, 질문 등 여러 속성을 띄기 때문에 답글 테이블로 성질을 통일 시켜야 할 듯

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 게시글 아이디

    private Long userId; // 글 작성자 아이디

    private Long adminId; // 관리자 아이디

    private String title; // 게시글 제목

    @Column(columnDefinition = "TEXT")
    private String content; // 게시글 내용

    private LocalDateTime createAt; // 작성 날짜

    private Long viewHits; // 조회수

    private Long value; // 중요도
}
