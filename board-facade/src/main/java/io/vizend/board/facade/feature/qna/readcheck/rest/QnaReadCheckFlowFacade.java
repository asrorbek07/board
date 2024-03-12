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
package io.vizend.board.facade.feature.qna.readcheck.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.readcheck.command.RegisterQnaReadCheckCommand;
import io.vizend.board.facade.feature.qna.readcheck.command.DeleteQnaReadChecksCommand;

public interface QnaReadCheckFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerQnaReadCheck(RegisterQnaReadCheckCommand command);
    CommandResponse deleteQnaReadChecks(DeleteQnaReadChecksCommand command);
}
