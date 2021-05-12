package rev.team.BOARD_SERVICE.domain.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import rev.team.BOARD_SERVICE.domain.entity.Notice;
import rev.team.BOARD_SERVICE.domain.mapping.NoticeSummary;

import java.util.Set;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    //TODO : 고정 된 공지글 한번에 다 가져오기 (내용은 제외하고)
    Set<NoticeSummary> findAllByPined(Boolean pined, Sort sort);
}
