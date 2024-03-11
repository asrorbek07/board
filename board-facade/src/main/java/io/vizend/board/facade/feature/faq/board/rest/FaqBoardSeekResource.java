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

import io.vizend.accent.domain.type.Offset;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.faq.board.flow.FaqBoardSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.feature.faq.board.query.FindFaqBoardQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.faq.board.query.FindFaqBoardsByBoardTypeQuery;
import io.vizend.board.facade.feature.faq.board.query.FindFaqBoardByOffsetQuery;

@RestController
@RequestMapping("/feature/faq/board")
@RequiredArgsConstructor
public class FaqBoardSeekResource implements FaqBoardSeekFacade {
    private final FaqBoardSeek faqBoardSeek;

    @Override
    @PostMapping("/find-faq-board/query")
    public QueryResponse<Board> findFaqBoard(@RequestBody FindFaqBoardQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String boardId = query.getBoardId();
        Board response = faqBoardSeek.findFaqBoard(boardId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-faq-boards-by-board-type/query")
    public QueryResponse<List<Board>> findFaqBoardsByBoardType(@RequestBody FindFaqBoardsByBoardTypeQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        List<Board> response = faqBoardSeek.findFaqBoards();
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-faq-board-by-offset/query")
    public QueryResponse<List<Board>> findFaqBoardByOffset(@RequestBody FindFaqBoardByOffsetQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        query.getOffset().setSortingField("registrationTime");
        query.getOffset().setSortDirection(Offset.SortDirection.DESCENDING);
        List<Board> response = faqBoardSeek.findFaqBoardByOffset(query.getOffset());
        query.setResponse(response);
        return query.getResponse();
    }
}
