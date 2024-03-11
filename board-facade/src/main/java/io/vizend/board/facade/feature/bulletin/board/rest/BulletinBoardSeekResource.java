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

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.board.flow.BulletinBoardSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.feature.bulletin.board.query.FindBulletinBoardQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.bulletin.board.query.FindBulletinBoardsQuery;

@RestController
@RequestMapping("/feature/bulletin/board")
@RequiredArgsConstructor
public class BulletinBoardSeekResource implements BulletinBoardSeekFacade {
    private final BulletinBoardSeek bulletinBoardSeek;

    @Override
    @PostMapping("/find-bulletin-board/query")
    public QueryResponse<Board> findBulletinBoard(@RequestBody FindBulletinBoardQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String boardId = query.getBoardId();
        Board response = bulletinBoardSeek.findBulletinBoard(boardId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-bulletin-boards/query")
    public QueryResponse<List<Board>> findBulletinBoards(@RequestBody FindBulletinBoardsQuery query) {
        //
        query.validate();
        List<Board> response = bulletinBoardSeek.findBulletinBoards();
        query.setResponse(response);
        return query.getResponse();
    }
}
