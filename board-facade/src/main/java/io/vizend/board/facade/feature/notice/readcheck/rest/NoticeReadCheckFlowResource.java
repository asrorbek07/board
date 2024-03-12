/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.readcheck.rest;

import io.vizend.board.feature.notice.readcheck.domain.sdo.NoticeReadCheckCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.readcheck.flow.NoticeReadCheckFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.notice.readcheck.command.RegisterNoticeReadCheckCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/notice/readcheck")
@RequiredArgsConstructor
public class NoticeReadCheckFlowResource implements NoticeReadCheckFlowFacade {
    //
    private final NoticeReadCheckFlow noticeReadCheckFlow;

    @Override
    @PostMapping("/register-notice-read-check/command")
    public CommandResponse registerNoticeReadCheck(@RequestBody RegisterNoticeReadCheckCommand command) {
        //
        command.validate();
        NoticeReadCheckCdo noticeReadCheckCdo = command.genNoticeReadCheckCdo();
        String entityId = noticeReadCheckFlow.registerNoticeReadCheck(noticeReadCheckCdo.genReadCheckCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }
}
