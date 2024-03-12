/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.thumbup.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.notice.thumbup.command.RegisterNoticeThumbUpCommand;

public interface NoticeThumbUpFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerNoticeThumbUp(RegisterNoticeThumbUpCommand command);
}
