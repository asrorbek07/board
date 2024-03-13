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

import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerRdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.answer.flow.QnaAnswerSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.facade.feature.qna.answer.query.FindQnaAnswerQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.qna.answer.query.FindQnaAnswersQuery;

@RestController
@RequestMapping("/feature/qna/answer")
@RequiredArgsConstructor
public class QnaAnswerSeekResource implements QnaAnswerSeekFacade {
    private final QnaAnswerSeek qnaAnswerSeek;

    @Override
    @PostMapping("/find-qna-answer/query")
    public QueryResponse<QnaAnswerRdo> findQnaAnswer(@RequestBody FindQnaAnswerQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String answerId = query.getAnswerId();
        QnaAnswerRdo response = qnaAnswerSeek.findQnaAnswer(answerId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-qna-answers/query")
    public QueryResponse<List<QnaAnswerRdo>> findQnaAnswers(@RequestBody FindQnaAnswersQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String questionId = query.getQuestionId();
        List<QnaAnswerRdo> response = qnaAnswerSeek.findQnaAnswers(questionId);
        query.setResponse(response);
        return query.getResponse();
    }
}
