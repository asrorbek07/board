/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.aggregate.board.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.aggregate.board.command.BoardCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RestController
@RequestMapping("/aggregate/board")
public class BoardResource implements BoardFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardLogic boardLogic;

    public BoardResource(BoardLogic boardLogic) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardLogic = boardLogic;
    }

    @Override
    @PostMapping("/board/register/command")
    public CommandResponse registerBoard(@RequestBody BoardCommand boardCommand) {
        /* Gen by Vizend Studio v5.1.0 */
        if (boardCommand.isMultiCdo()) {
            List<String> entityIds = boardLogic.registerBoards(boardCommand.getBoardCdos());
            boardCommand.setResponse(entityIds);
        } else {
            String entityId = boardLogic.registerBoard(boardCommand.getBoardCdo());
            boardCommand.setResponse(entityId);
        }
        return boardCommand.getResponse();
    }

    @Override
    @PostMapping("/board/modify/command")
    public CommandResponse modifyBoard(@RequestBody BoardCommand boardCommand) {
        /* Gen by Vizend Studio v5.1.0 */
        boardLogic.modifyBoard(boardCommand.getBoardId(), boardCommand.getNameValues());
        boardCommand.setResponse(boardCommand.getBoardId());
        return boardCommand.getResponse();
    }

    @Override
    @PostMapping("/board/remove/command")
    public CommandResponse removeBoard(@RequestBody BoardCommand boardCommand) {
        /* Gen by Vizend Studio v5.1.0 */
        boardLogic.removeBoard(boardCommand.getBoardId());
        boardCommand.setResponse(new CommandResponse(boardCommand.getBoardId()));
        return boardCommand.getResponse();
    }
}
