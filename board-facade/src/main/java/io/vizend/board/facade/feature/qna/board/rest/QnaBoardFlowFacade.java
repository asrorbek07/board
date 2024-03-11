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
package io.vizend.board.facade.feature.qna.board.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.board.command.RegisterQnaBoardCommand;
import io.vizend.board.facade.feature.qna.board.command.ModifyQnaBoardCommand;
import io.vizend.board.facade.feature.qna.board.command.RemoveQnaBoardCommand;

public interface QnaBoardFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerQanBoard(RegisterQnaBoardCommand command);
    CommandResponse modifyQanBoard(ModifyQnaBoardCommand command);
    CommandResponse removeQanBoard(RemoveQnaBoardCommand command);
}
