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
package io.vizend.board.facade.feature.faq.board.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.faq.board.command.ModifyFaqBoardCommand;
import io.vizend.board.facade.feature.faq.board.command.RegisterFaqBoardCommand;
import io.vizend.board.facade.feature.faq.board.command.RemoveFaqBoardCommand;

public interface FaqBoardFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse modifyFaqBoard(ModifyFaqBoardCommand command);
    CommandResponse registerFaqBoard(RegisterFaqBoardCommand command);
    CommandResponse removeFaqBoard(RemoveFaqBoardCommand command);
}
