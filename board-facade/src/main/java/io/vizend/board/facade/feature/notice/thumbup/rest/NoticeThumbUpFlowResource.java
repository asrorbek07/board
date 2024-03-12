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
import io.vizend.board.facade.feature.notice.thumbup.command.RegisterNoticeThumbUpCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;

@RestController
@RequestMapping("/feature/notice/thumbup")
@RequiredArgsConstructor
public class NoticeThumbUpFlowResource implements NoticeThumbUpFlowFacade {
    //
    private final NoticeThumbUpFlow noticeThumbUpFlow;

    @Override
    @PostMapping("/register-notice-thumb-up/command")
    public CommandResponse registerNoticeThumbUp(@RequestBody RegisterNoticeThumbUpCommand command) {
        //
        command.validate();
        NoticeThumbUpRecordCdo noticeThumbUpRecordCdo = command.genNoticeThumbUpRecordCdo();
        String entityId = noticeThumbUpFlow.registerNoticeThumbUp(noticeThumbUpRecordCdo.genThumbUpRecordCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }
}
