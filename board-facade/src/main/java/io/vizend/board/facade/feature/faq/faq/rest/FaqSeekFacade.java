/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.faq.rest;

import io.vizend.accent.domain.message.QueryResponse;
import org.springframework.data.domain.Page;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.feature.faq.faq.query.FindFAQBoardsByOffsetQuery;

public interface FaqSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Page<Board>> findFAQBoardsByOffset(FindFAQBoardsByOffsetQuery query);
}
