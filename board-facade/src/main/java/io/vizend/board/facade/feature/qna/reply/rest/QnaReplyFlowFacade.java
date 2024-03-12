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
package io.vizend.board.facade.feature.qna.reply.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.reply.command.RegisterQnaReplyCommand;
import io.vizend.board.facade.feature.qna.reply.command.ModifyQnaReplyCommand;
import io.vizend.board.facade.feature.qna.reply.command.RemoveQnaReplyCommand;

public interface QnaReplyFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerQnaReply(RegisterQnaReplyCommand command);
    CommandResponse modifyQnaReply(ModifyQnaReplyCommand command);
    CommandResponse removeQnaReply(RemoveQnaReplyCommand command);
}
