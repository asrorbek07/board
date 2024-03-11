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
package io.vizend.board.facade.feature.notice.board.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.board.flow.NoticeBoardSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.notice.board.query.FindNoticeBoardQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.aggregate.board.domain.entity.Board;
import java.util.List;
import io.vizend.board.facade.feature.notice.board.query.FindNoticeBoardsQuery;

@RestController
@RequestMapping("/feature/notice/board")
@RequiredArgsConstructor
public class NoticeBoardSeekResource implements NoticeBoardSeekFacade {
    private final NoticeBoardSeek noticeBoardSeek;

    @Override
    @PostMapping("/find-notice-board/query")
    public QueryResponse<Board> findNoticeBoard(@RequestBody FindNoticeBoardQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String postId = query.getPostId();
        Board response = noticeBoardSeek.findNoticeBoard(postId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-notice-boards/query")
    public QueryResponse<List<Board>> findNoticeBoards(@RequestBody FindNoticeBoardsQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        List<Board> response = noticeBoardSeek.findNoticeBoards();
        query.setResponse(response);
        return query.getResponse();
    }
}
