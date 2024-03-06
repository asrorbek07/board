/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.aggregate.board.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.aggregate.board.command.BoardCommand;

public interface BoardFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerBoard(BoardCommand boardCommand);
    CommandResponse modifyBoard(BoardCommand boardCommand);
    CommandResponse removeBoard(BoardCommand boardCommand);
}
