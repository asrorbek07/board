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
package io.vizend.board.feature.qna.board.flow;

import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.feature.action.BoardAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.board.domain.entity.Board;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaBoardSeek {
    private final BoardAction boardAction;

    public Board findQanBoard(String boardId) {
        // 
        return boardAction.findBoard(boardId);
    }

    public List<Board> findQanBoards() {
        return boardAction.findBoards(BoardType.QNABoard);
    }
}
