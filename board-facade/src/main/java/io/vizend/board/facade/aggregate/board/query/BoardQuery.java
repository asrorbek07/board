/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.aggregate.board.query;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.board.facade.BoardRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.store.BoardStore;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(BoardRole.Director)
public class BoardQuery extends QueryRequest<Board> {
    /* Gen by Vizend Studio v5.1.0 */
    private String boardId;

    public void execute(BoardStore boardStore) {
        /* Gen by Vizend Studio v5.1.0 */
        setResponse(boardStore.retrieve(boardId));
    }
}
