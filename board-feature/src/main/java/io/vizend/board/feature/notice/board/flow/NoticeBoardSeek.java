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

package io.vizend.board.feature.notice.board.flow;

import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeBoardSeek {
    private final BoardLogic boardLogic; // 

    public Board findNoticeBoard(String boardId) {
        // 
        return boardLogic.findBoard(boardId);
    }

    public List<Board> findNoticeBoards() {
        //
        return boardLogic.findBoardsByType(BoardType.NoticeBoard);
    }
}
