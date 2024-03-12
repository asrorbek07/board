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

import io.vizend.board.feature.qna.readcheck.domain.sdo.QnaReadCheckCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.readcheck.flow.QnaReadCheckFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.readcheck.command.RegisterQnaReadCheckCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.qna.readcheck.command.DeleteQnaReadChecksCommand;

@RestController
@RequestMapping("/feature/qna/readcheck")
@RequiredArgsConstructor
public class QnaReadCheckFlowResource implements QnaReadCheckFlowFacade {
    //
    private final QnaReadCheckFlow qnaReadCheckFlow;

    @Override
    @PostMapping("/register-qna-read-check/command")
    public CommandResponse registerQnaReadCheck(@RequestBody RegisterQnaReadCheckCommand command) {
        //
        command.validate();
        QnaReadCheckCdo qnaReadCheckCdo = command.genQnaReadCheckCdo();
        String entityId = qnaReadCheckFlow.registerQnaReadCheck(qnaReadCheckCdo.genReadCheckCdo());
        command.setResponse(entityId);
        return command.getResponse();

    }

    @Override
    @PostMapping("/delete-qna-read-checks/command")
    public CommandResponse deleteQnaReadChecks(@RequestBody DeleteQnaReadChecksCommand command) {
        //
        command.validate();
        command.validate();
        String postId = command.getPostId();
        qnaReadCheckFlow.deleteQnaReadChecks(postId);
        return command.getResponse();
    }
}
