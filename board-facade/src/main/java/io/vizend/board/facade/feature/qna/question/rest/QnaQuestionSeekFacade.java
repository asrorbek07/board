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
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionQuery;
import java.util.List;
import io.vizend.board.facade.feature.qna.question.query.FindQnaQuestionsQuery;
import io.vizend.board.feature.qna.question.domain.sdo.QnaQuestionRdo;

public interface QnaQuestionSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<QnaQuestionRdo> findQnaQuestion(FindQnaQuestionQuery query);
    QueryResponse<List<QnaQuestionRdo>> findQnaQuestions(FindQnaQuestionsQuery query);
}
