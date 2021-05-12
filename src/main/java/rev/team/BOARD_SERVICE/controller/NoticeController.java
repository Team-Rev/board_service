package rev.team.BOARD_SERVICE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rev.team.BOARD_SERVICE.domain.dto.NoticeSummaryDTO;
import rev.team.BOARD_SERVICE.service.NoticeService;

import java.util.List;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice-pined")
    public List<NoticeSummaryDTO> getNoticeSummaries(){
        return noticeService.getNoticeSummaries();
    }

}
