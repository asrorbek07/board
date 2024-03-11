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
package io.vizend.board.facade.feature.qna.answer.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.answer.command.RegisterQnaAnswerCommand;
import io.vizend.board.facade.feature.qna.answer.command.ModifyQnaAnswerCommand;
import io.vizend.board.facade.feature.qna.answer.command.RemoveQnaAnswerCommand;

public interface QnaAnswerFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerQnaAnswer(RegisterQnaAnswerCommand command);
    CommandResponse modifyQnaAnswer(ModifyQnaAnswerCommand command);
    CommandResponse removeQnaAnswer(RemoveQnaAnswerCommand command);
}
