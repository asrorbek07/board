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
package io.vizend.board.facade.feature.qna.answer.rest;

import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.answer.flow.QnaAnswerFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.answer.command.RegisterQnaAnswerCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.qna.answer.command.ModifyQnaAnswerCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.qna.answer.command.RemoveQnaAnswerCommand;

@RestController
@RequestMapping("/feature/qna/answer")
@RequiredArgsConstructor
public class QnaAnswerFlowResource implements QnaAnswerFlowFacade {
    //
    private final QnaAnswerFlow qnaAnswerFlow;

    @Override
    @PostMapping("/register-qna-answer/command")
    public CommandResponse registerQnaAnswer(@RequestBody RegisterQnaAnswerCommand command) {
        //
        QnaAnswerCdo qnaAnswerCdo = command.genQnaAnswerCdo();
        String entityId = qnaAnswerFlow.registerQnaAnswer(qnaAnswerCdo.genCommentCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-qna-answer/command")
    public CommandResponse modifyQnaAnswer(@RequestBody ModifyQnaAnswerCommand command) {
        //
        command.validate();
        String answerId = command.getAnswerId();
        NameValueList nameValueList = command.getNameValueList();
        qnaAnswerFlow.modifyQnaAnswer(answerId, nameValueList);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-qna-answer/command")
    public CommandResponse removeQnaAnswer(@RequestBody RemoveQnaAnswerCommand command) {
        //
        command.validate();
        String answerId = command.getAnswerId();
        qnaAnswerFlow.removeQnaAnswer(answerId);
        return command.getResponse();
    }
}
