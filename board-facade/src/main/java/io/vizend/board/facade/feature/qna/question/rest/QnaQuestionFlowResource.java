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
package io.vizend.board.facade.feature.qna.question.rest;

import io.vizend.board.feature.qna.question.domain.sdo.QnaQuestionCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.question.flow.QnaQuestionFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.question.command.RegisterQnaQuestionCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.qna.question.command.ModifyQnaQuestionCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.qna.question.command.RemoveQnaQuestionCommand;

@RestController
@RequestMapping("/feature/qna/question")
@RequiredArgsConstructor
public class QnaQuestionFlowResource implements QnaQuestionFlowFacade {
    //
    private final QnaQuestionFlow qnaQuestionFlow;

    @Override
    @PostMapping("/register-qna-question/command")
    public CommandResponse registerQnaQuestion(@RequestBody RegisterQnaQuestionCommand command) {
        //
        command.validate();
        QnaQuestionCdo qnaQuestionCdo = command.genQnaQuestionCdo();
        String entityId = qnaQuestionFlow.registerQnaQuestion(qnaQuestionCdo.genPostCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-qna-question/command")
    public CommandResponse modifyQnaQuestion(@RequestBody ModifyQnaQuestionCommand command) {
        //
        command.validate();
        String questionId = command.getQuestionId();
        NameValueList nameValueList = command.getNameValueList();
        String entityId = qnaQuestionFlow.modifyQnaQuestion(questionId, nameValueList);
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-qna-question/command")
    public CommandResponse removeQnaQuestion(@RequestBody RemoveQnaQuestionCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String questionId = command.getQuestionId();
        String entityId = qnaQuestionFlow.removeQnaQuestion(questionId);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
