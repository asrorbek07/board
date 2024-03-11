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

import io.vizend.board.feature.faq.board.domain.sdo.FaqBoardCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.faq.board.flow.FaqBoardFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.faq.board.command.ModifyFaqBoardCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.faq.board.command.RegisterFaqBoardCommand;
import io.vizend.board.facade.feature.faq.board.command.RemoveFaqBoardCommand;

@RestController
@RequestMapping("/feature/faq/board")
@RequiredArgsConstructor
public class FaqBoardFlowResource implements FaqBoardFlowFacade {
    //
    private final FaqBoardFlow faqBoardFlow;

    @Override
    @PostMapping("/modify-faq-board/command")
    public CommandResponse modifyFaqBoard(@RequestBody ModifyFaqBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String boardId = command.getBoardId();
        NameValueList nameValueList = command.getNameValueList();
        String entityId = faqBoardFlow.modifyFaqBoard(boardId, nameValueList);
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/register-faq-board/command")
    public CommandResponse registerFaqBoard(@RequestBody RegisterFaqBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        FaqBoardCdo faqBoardCdo = command.genFaqBoardCdo();
        String entityId = faqBoardFlow.registerFaqBoard(faqBoardCdo.genBoardCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-faq-board/command")
    public CommandResponse removeFaqBoard(@RequestBody RemoveFaqBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String boardId = command.getBoardId();
        String entityId = faqBoardFlow.removeFaqBoard(boardId);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
