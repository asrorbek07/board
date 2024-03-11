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

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.question.flow.QnaQuestionSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionsQuery;

@RestController
@RequestMapping("/feature/qna/question")
@RequiredArgsConstructor
public class QnaQuestionSeekResource implements QnaQuestionSeekFacade {
    private final QnaQuestionSeek qnaQuestionSeek;

    @Override
    @PostMapping("/find-qna-question/query")
    public QueryResponse<Post> findQnaQuestion(@RequestBody FindQnaQuestionQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String questionId = query.getQuestionId();
        Post response = qnaQuestionSeek.findQnaQuestion(questionId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-qna-questions/query")
    public QueryResponse<List<Post>> findQnaQuestions(@RequestBody FindQnaQuestionsQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String boardId = query.getBoardId();
        List<Post> response = qnaQuestionSeek.findQnaQuestions(boardId);
        query.setResponse(response);
        return query.getResponse();
    }
}
