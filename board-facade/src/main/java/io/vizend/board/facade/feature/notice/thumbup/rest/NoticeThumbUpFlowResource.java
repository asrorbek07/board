/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.thumbup.rest;

import io.vizend.board.feature.notice.thumbup.domain.sdo.NoticeThumbUpRecordCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.thumbup.flow.NoticeThumbUpFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.notice.thumbup.command.ToggleNoticeThumbUpCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/notice/thumbup")
@RequiredArgsConstructor
public class NoticeThumbUpFlowResource implements NoticeThumbUpFlowFacade {
    //
    private final NoticeThumbUpFlow noticeThumbUpFlow;

    @Override
    @PostMapping("/toggle-notice-thumb-up/command")
    public CommandResponse toggleNoticeThumbUp(@RequestBody ToggleNoticeThumbUpCommand command) {
        //
        command.validate();
        NoticeThumbUpRecordCdo noticeThumbUpRecordCdo = command.genNoticeThumbUpRecordCdo();
        String entityId = noticeThumbUpFlow.toggleNoticeThumbUp(noticeThumbUpRecordCdo.genThumbUpRecordCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }
}
