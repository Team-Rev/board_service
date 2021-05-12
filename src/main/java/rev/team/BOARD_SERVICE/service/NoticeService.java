package rev.team.BOARD_SERVICE.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rev.team.BOARD_SERVICE.domain.dto.NoticeSummaryDTO;
import rev.team.BOARD_SERVICE.domain.mapping.NoticeSummary;
import rev.team.BOARD_SERVICE.domain.repository.NoticeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<NoticeSummaryDTO> getNoticeSummaries() {
        RestTemplate restTemplate = new RestTemplate();
        List<NoticeSummaryDTO> noticeSummaryDTOS= new ArrayList<>();
        for(NoticeSummary noticeSummary : noticeRepository.findAllByPined(true, Sort.by(Sort.Direction.DESC, "noticeId"))){
            String nickname = restTemplate.getForObject("http://localhost:8760/nickname?id="+noticeSummary.getUserId() ,String.class);
            noticeSummaryDTOS.add(NoticeSummaryDTO.builder()
                    .noticeId(noticeSummary.getNoticeId())
                    .title(noticeSummary.getTitle())
                    .postDate(noticeSummary.getPostDate())
                    .hits(noticeSummary.getHits())
                    .nickname(nickname)
                    .build());
        }
        return noticeSummaryDTOS;
    }
}
