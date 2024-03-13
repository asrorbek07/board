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

import io.vizend.board.feature.qna.question.domain.sdo.QnaQuestionRdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.question.flow.QnaQuestionSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionsQuery;

@RestController
@RequestMapping("/feature/qna/question")
@RequiredArgsConstructor
public class QnaQuestionSeekResource implements QnaQuestionSeekFacade {
    //
    private final QnaQuestionSeek qnaQuestionSeek;

    @Override
    @PostMapping("/find-qna-question/query")
    public QueryResponse<QnaQuestionRdo> findQnaQuestion(@RequestBody FindQnaQuestionQuery query) {
        //
        query.validate();
        String questionId = query.getQuestionId();
        QnaQuestionRdo response = qnaQuestionSeek.findQnaQuestionRdo(questionId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-qna-questions/query")
    public QueryResponse<List<QnaQuestionRdo>> findQnaQuestions(@RequestBody FindQnaQuestionsQuery query) {
        //
        query.validate();
        String boardId = query.getBoardId();
        List<QnaQuestionRdo> response = qnaQuestionSeek.findQnaQuestions(boardId);
        query.setResponse(response);
        return query.getResponse();
    }
}
