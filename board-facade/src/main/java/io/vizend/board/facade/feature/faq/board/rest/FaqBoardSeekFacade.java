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
package io.vizend.board.facade.feature.faq.board.rest;

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.feature.faq.board.query.FindFaqBoardQuery;
import java.util.List;
import io.vizend.board.facade.feature.faq.board.query.FindFaqBoardsByBoardTypeQuery;
import io.vizend.board.facade.feature.faq.board.query.FindFaqBoardByOffsetQuery;

public interface FaqBoardSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Board> findFaqBoard(FindFaqBoardQuery query);
    QueryResponse<List<Board>> findFaqBoardsByBoardType(FindFaqBoardsByBoardTypeQuery query);
    QueryResponse<List<Board>> findFaqBoardByOffset(FindFaqBoardByOffsetQuery query);
}
