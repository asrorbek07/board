/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store;

import io.vizend.accent.domain.type.Offset;
import io.vizend.board.aggregate.board.domain.entity.Board;
import org.springframework.data.domain.Page;

public interface BoardOptionStore {
    //
    Page<Board> retrieve(String stageId, Offset offset);
}
