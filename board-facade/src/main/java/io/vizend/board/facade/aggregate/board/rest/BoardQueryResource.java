/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.aggregate.board.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.vizend.board.aggregate.board.store.BoardStore;
import org.springframework.data.mongodb.core.MongoTemplate;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.aggregate.board.query.BoardQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.aggregate.board.query.BoardDynamicQuery;
import java.util.List;
import io.vizend.board.facade.aggregate.board.query.BoardsDynamicQuery;

@RestController
@RequestMapping("/aggregate/board")
public class BoardQueryResource implements BoardQueryFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardStore boardStore;
    private final MongoTemplate mongoTemplate;

    public BoardQueryResource(BoardStore boardStore, MongoTemplate mongoTemplate) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardStore = boardStore;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @PostMapping("/board/query")
    public QueryResponse<Board> execute(@RequestBody BoardQuery boardQuery) {
        /* Gen by Vizend Studio v5.1.0 */
        boardQuery.execute(boardStore);
        return boardQuery.getResponse();
    }

    @Override
    @PostMapping("/board/dynamic-single/query")
    public QueryResponse<Board> execute(@RequestBody BoardDynamicQuery boardDynamicQuery) {
        /* Gen by Vizend Studio v5.1.0 */
        boardDynamicQuery.execute(mongoTemplate);
        return boardDynamicQuery.getResponse();
    }

    @Override
    @PostMapping("/board/dynamic-multi/query")
    public QueryResponse<List<Board>> execute(@RequestBody BoardsDynamicQuery boardsDynamicQuery) {
        /* Gen by Vizend Studio v5.1.0 */
        boardsDynamicQuery.execute(mongoTemplate);
        return boardsDynamicQuery.getResponse();
    }
}
