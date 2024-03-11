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

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.facade.feature.qna.answer.query.FindQnaAnswerQuery;
import java.util.List;
import io.vizend.board.facade.feature.qna.answer.query.FindQnaAnswersQuery;

public interface QnaAnswerSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Comment> findQnaAnswer(FindQnaAnswerQuery query);
    QueryResponse<List<Comment>> findQnaAnswers(FindQnaAnswersQuery query);
}
