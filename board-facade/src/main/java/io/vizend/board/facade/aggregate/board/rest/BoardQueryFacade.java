/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.aggregate.board.rest;

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.aggregate.board.query.BoardQuery;
import io.vizend.board.facade.aggregate.board.query.BoardDynamicQuery;
import java.util.List;
import io.vizend.board.facade.aggregate.board.query.BoardsDynamicQuery;

public interface BoardQueryFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Board> execute(BoardQuery boardQuery);
    QueryResponse<Board> execute(BoardDynamicQuery boardDynamicQuery);
    QueryResponse<List<Board>> execute(BoardsDynamicQuery boardsDynamicQuery);
}
