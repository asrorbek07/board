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

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.notice.post.command.RegisterNoticePostCommand;
import io.vizend.board.facade.feature.notice.post.command.ModifyNoticePostCommand;
import io.vizend.board.facade.feature.notice.post.command.RemoveNoticePostCommand;

public interface NoticePostFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerNoticePost(RegisterNoticePostCommand command);
    CommandResponse modifyNoticePost(ModifyNoticePostCommand command);
    CommandResponse removeNoticePost(RemoveNoticePostCommand command);
}
