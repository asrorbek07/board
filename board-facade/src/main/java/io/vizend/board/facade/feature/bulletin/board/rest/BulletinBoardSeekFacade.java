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
package io.vizend.board.facade.feature.bulletin.board.rest;

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.feature.bulletin.board.query.FindBulletinBoardQuery;
import java.util.List;
import io.vizend.board.facade.feature.bulletin.board.query.FindBulletinBoardsQuery;

public interface BulletinBoardSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Board> findBulletinBoard(FindBulletinBoardQuery query);
    QueryResponse<List<Board>> findBulletinBoards(FindBulletinBoardsQuery query);
}
