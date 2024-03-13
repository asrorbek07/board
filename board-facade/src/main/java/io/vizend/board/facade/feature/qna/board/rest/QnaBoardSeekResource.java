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
package io.vizend.board.facade.feature.qna.board.rest;

import io.vizend.board.facade.feature.qna.board.query.FindQnaBoardQuery;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.board.flow.QnaBoardSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.board.domain.entity.Board;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.qna.board.query.FindQnaBoardsQuery;

@RestController
@RequestMapping("/feature/qna/board")
@RequiredArgsConstructor
public class QnaBoardSeekResource implements QnaBoardSeekFacade {
    private final QnaBoardSeek qanBoardSeek;

    @Override
    @PostMapping("/find-qna-board/query")
    public QueryResponse<Board> findQanBoard(@RequestBody FindQnaBoardQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String boardId = query.getBoardId();
        Board response = qanBoardSeek.findQanBoard(boardId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-qna-boards/query")
    public QueryResponse<List<Board>> findQanBoards(@RequestBody FindQnaBoardsQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        List<Board> response = qanBoardSeek.findQanBoards();
        query.setResponse(response);
        return query.getResponse();
    }
}
