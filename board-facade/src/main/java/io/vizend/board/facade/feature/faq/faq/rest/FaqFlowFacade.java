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
package io.vizend.board.facade.feature.faq.faq.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.faq.faq.command.RegisterFaqBoardCommand;
import io.vizend.board.facade.feature.faq.faq.command.RegisterFaqPostCommand;

public interface FaqFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerFaqBoard(RegisterFaqBoardCommand command);
    CommandResponse registerFaqPost(RegisterFaqPostCommand command);
}
