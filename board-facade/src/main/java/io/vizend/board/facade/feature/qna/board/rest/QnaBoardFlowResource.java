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

import io.vizend.board.facade.feature.qna.board.command.RegisterQnaBoardCommand;
import io.vizend.board.facade.feature.qna.board.command.RemoveQnaBoardCommand;
import io.vizend.board.feature.qna.board.domain.sdo.QnaBoardCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.board.flow.QnaBoardFlow;
import io.vizend.accent.domain.message.CommandResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.qna.board.command.ModifyQnaBoardCommand;
import io.vizend.accent.domain.type.NameValueList;

@RestController
@RequestMapping("/feature/qan/board")
@RequiredArgsConstructor
public class QnaBoardFlowResource implements QnaBoardFlowFacade {
    private final QnaBoardFlow qnaBoardFlow;

    @Override
    @PostMapping("/register-qan-board/command")
    public CommandResponse registerQanBoard(@RequestBody RegisterQnaBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        QnaBoardCdo qnaBoardCdo = command.genQanBoardCdo();
        String entityId = qnaBoardFlow.registerQanBoard(qnaBoardCdo.genBoardCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-qan-board/command")
    public CommandResponse modifyQanBoard(@RequestBody ModifyQnaBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String boardId = command.getBoardId();
        NameValueList nameValueList = command.getNameValueList();
        String entityId = qnaBoardFlow.modifyQanBoard(boardId, nameValueList);
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-qan-board/command")
    public CommandResponse removeQanBoard(@RequestBody RemoveQnaBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String boardId = command.getBoardId();
        String entityId = qnaBoardFlow.removeQanBoard(boardId);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
