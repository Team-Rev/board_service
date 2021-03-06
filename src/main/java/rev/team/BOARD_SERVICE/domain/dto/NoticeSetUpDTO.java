package rev.team.BOARD_SERVICE.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NoticeSetUpDTO {
    private List<NoticeSummaryDTO> pined;
    private PageNoticeSummaryDTO page;
}
