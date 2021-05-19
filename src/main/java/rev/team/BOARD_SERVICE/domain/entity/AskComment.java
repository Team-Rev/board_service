package rev.team.BOARD_SERVICE.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ask_comment")
public class AskComment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ask_comment_id")
    private Long askCommentId;

    private String userId; // 작성자
    private String nickname; // 작성자 작성 시 닉네임

    @Column(columnDefinition = "TEXT")
    private String content; // 댓글

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate; // 작성일
}
