/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.readcheck.rest;

import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.facade.feature.qna.readcheck.query.FindQnaReadChecksQuery;

public interface QnaReadCheckSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<List<ReadCheck>> findQnaReadChecks(FindQnaReadChecksQuery query);
}
