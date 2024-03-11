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
package io.vizend.board.facade.feature.notice.board.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.notice.board.command.RegisterNoticeBoardCommand;
import io.vizend.board.facade.feature.notice.board.command.ModifyNoticeBoardCommand;
import io.vizend.board.facade.feature.notice.board.command.RemoveNoticeBoardCommand;

public interface NoticeBoardFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerNoticeBoard(RegisterNoticeBoardCommand command);
    CommandResponse modifyNoticeBoard(ModifyNoticeBoardCommand command);
    CommandResponse removeNoticeBoard(RemoveNoticeBoardCommand command);
}
