package rev.team.BOARD_SERVICE.domain.mapping;

import java.util.Date;

public interface NoticeSummary {
    Long getNoticeId(); // ID
    String getUserId(); // 작성자
    String getTitle(); // 제목
    Date getPostDate(); // 작성일
    Integer getHits(); // 조회수
}
