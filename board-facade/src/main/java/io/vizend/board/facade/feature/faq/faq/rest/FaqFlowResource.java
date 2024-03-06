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

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.faq.faq.flow.FaqFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.faq.faq.command.RegisterFaqBoardCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.facade.feature.faq.faq.command.RegisterFaqPostCommand;
import io.vizend.board.feature.faq.faq.domain.sdo.FaqPostCdo;

@RestController
@RequestMapping("/feature/faq/faq")
@RequiredArgsConstructor
public class FaqFlowResource implements FaqFlowFacade {
    private final FaqFlow faqFlow; // Gen by Vizend Studio v5.1.0

    @Override
    @PostMapping("/register-faq-board/command")
    public CommandResponse registerFAQBoard(@RequestBody RegisterFaqBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        BoardCdo boardCdo = command.getBoardCdo();
        String entityId = faqFlow.registerFAQBoard(boardCdo);
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/register-faq-post/command")
    public CommandResponse registerFaqPost(@RequestBody RegisterFaqPostCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        FaqPostCdo faqPostCdo = command.getFaqPostCdo();
        String entityId = faqFlow.registerFaqPost(faqPostCdo);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
