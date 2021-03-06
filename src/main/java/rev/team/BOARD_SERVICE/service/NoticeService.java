package rev.team.BOARD_SERVICE.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rev.team.BOARD_SERVICE.domain.dto.NoticeSetUpDTO;
import rev.team.BOARD_SERVICE.domain.dto.NoticeSummaryDTO;
import rev.team.BOARD_SERVICE.domain.dto.PageNoticeSummaryDTO;
import rev.team.BOARD_SERVICE.domain.entity.Notice;
import rev.team.BOARD_SERVICE.domain.mapping.NoticeSummary;
import rev.team.BOARD_SERVICE.domain.repository.NoticeRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
//    private final RestTemplate restTemplate;
    private List<NoticeSummaryDTO> noticeSummaryDTOS;
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
//        restTemplate = new RestTemplate();
    }

    //처음 공지사항 로딩 데이터
    public NoticeSetUpDTO getSetUpNoticeSummary(Integer page){
        return NoticeSetUpDTO.builder()
                .pined(this.getPinedNoticeSummaries())
                .page(this.getNoticeSummaries(page))
                .build();
    }

    //고정 된 글 한번에 다 가져오기(정렬 포함) Completed at 2021-05-12 17:44
    public List<NoticeSummaryDTO> getPinedNoticeSummaries() {
        noticeSummaryDTOS= new ArrayList<>();
        for(NoticeSummary noticeSummary : noticeRepository.findAllByPined(true, Sort.by(Sort.Direction.DESC, "noticeId"))){
//            String nickname = restTemplate.getForObject("http://localhost:8760/nickname?id="+noticeSummary.getUserId() ,String.class);
            noticeSummaryDTOS.add(NoticeSummaryDTO.builder()
                    .noticeId(noticeSummary.getNoticeId())
                    .title(noticeSummary.getTitle())
                    .postDate(noticeSummary.getPostDate())
                    .hits(noticeSummary.getHits())
                    .nickname("관리자")
                    .build());
        }
        return noticeSummaryDTOS;
    }

    //고정 안 된 글 전체 페이지 갯수 구해서 전송, 1개 페이지는 10개 글
    public PageNoticeSummaryDTO getNoticeSummaries(Integer page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "noticeId");
        noticeSummaryDTOS = new ArrayList<>();
        for(NoticeSummary noticeSummary : noticeRepository.findAllByPined(false, pageable)){
//            String nickname = restTemplate.getForObject("http://localhost:8760/nickname?id="+noticeSummary.getUserId() ,String.class);
            noticeSummaryDTOS.add(NoticeSummaryDTO.builder()
                    .noticeId(noticeSummary.getNoticeId())
                    .title(noticeSummary.getTitle())
                    .postDate(noticeSummary.getPostDate())
                    .hits(noticeSummary.getHits())
                    .nickname("관리자")
                    .build());
        }
        return PageNoticeSummaryDTO.builder()
                .pageCount(noticeRepository.countByPined(false))
                .notices(noticeSummaryDTOS)
                .build();
    }

    //지정된 게시글 컨텐츠만 가져오기(조회)
    @Transactional
    public String getNoticeContent(Long id) {
        Optional<Notice> notice = noticeRepository.findById(id);
        if(notice.isPresent()){
            noticeRepository.hits(notice.get().getNoticeId());
            return notice.get().getContent();
        }
        return "NONE";
    }

    public Notice save(Notice notice) {
        noticeRepository.save(notice);
        return notice;
    }

    public String deletePost(Long id) {
        noticeRepository.deleteById(id);
        return "OK";
    }

    public String updatePost(Notice notice) {
        Notice updateNotice = noticeRepository.findById(notice.getNoticeId()).get();

        updateNotice.setTitle(notice.getTitle());
        updateNotice.setContent(notice.getContent());

        noticeRepository.save(updateNotice);

        return "OK";
    }
}
