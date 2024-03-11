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
package io.vizend.board.facade.feature.qna.question.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.question.command.RegisterQnaQuestionCommand;
import io.vizend.board.facade.feature.qna.question.command.ModifyQnaQuestionCommand;
import io.vizend.board.facade.feature.qna.question.command.RemoveQnaQuestionCommand;

public interface QnaQuestionFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerQnaQuestion(RegisterQnaQuestionCommand command);
    CommandResponse modifyQnaQuestion(ModifyQnaQuestionCommand command);
    CommandResponse removeQnaQuestion(RemoveQnaQuestionCommand command);
}
