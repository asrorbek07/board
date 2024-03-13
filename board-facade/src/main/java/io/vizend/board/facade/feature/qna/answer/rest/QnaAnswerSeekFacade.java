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
import io.vizend.board.facade.feature.qna.answer.query.FindQnaAnswerQuery;
import java.util.List;
import io.vizend.board.facade.feature.qna.answer.query.FindQnaAnswersQuery;
import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerRdo;

public interface QnaAnswerSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<QnaAnswerRdo> findQnaAnswer(FindQnaAnswerQuery query);
    QueryResponse<List<QnaAnswerRdo>> findQnaAnswers(FindQnaAnswersQuery query);
}
