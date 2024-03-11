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

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionQuery;
import java.util.List;
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionsQuery;

public interface QnaQuestionSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Post> findQnaQuestion(FindQnaQuestionQuery query);
    QueryResponse<List<Post>> findQnaQuestions(FindQnaQuestionsQuery query);
}
