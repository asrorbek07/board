/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store;

import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;

import java.util.List;

public interface BoardOptionStore {
    List<Board> retrieveAllByBoardType(BoardType boardType);

    boolean existsByTitle(String title);
}
