/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.post.rest;

import io.vizend.board.feature.notice.post.domain.sdo.NoticePostCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.post.flow.NoticePostFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.notice.post.command.RegisterNoticePostCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.aggregate.post.domain.entity.vo.ReportOption;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.facade.feature.notice.post.command.ModifyNoticePostCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.notice.post.command.RemoveNoticePostCommand;

@RestController
@RequestMapping("/feature/notice/post")
@RequiredArgsConstructor
public class NoticePostFlowResource implements NoticePostFlowFacade {
    private final NoticePostFlow noticePostFlow;

    @Override
    @PostMapping("/register-notice-post/command")
    public CommandResponse registerNoticePost(@RequestBody RegisterNoticePostCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        NoticePostCdo noticePostCdo = command.genNoticePostCdo();
        String entityId = noticePostFlow.registerNoticePost(noticePostCdo.genPostCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-notice-post/command")
    public CommandResponse modifyNoticePost(@RequestBody ModifyNoticePostCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String postId = command.getPostId();
        NameValueList nameValueList = command.getNameValueList();
        String entityId = noticePostFlow.modifyNoticePost(postId, nameValueList);
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-notice-post/command")
    public CommandResponse removeNoticePost(@RequestBody RemoveNoticePostCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String postId = command.getPostId();
        String entityId = noticePostFlow.removeNoticePost(postId);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
