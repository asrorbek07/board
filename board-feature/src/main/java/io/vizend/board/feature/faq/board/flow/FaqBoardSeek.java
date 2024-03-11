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
/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.faq.board.flow;

import io.vizend.accent.domain.type.Offset;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.board.domain.entity.Board;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqBoardSeek {
    //
    private final BoardLogic boardLogic;

    public Board findFaqBoard(String boardId) {
        // 
        return boardLogic.findBoard( boardId);
    }

    public List<Board> findFaqBoards() {
        // 
        return boardLogic.findBoardsByType(BoardType.FAQBoard);
    }

    public List<Board> findFaqBoardByOffset(Offset offset) {
        //
        return boardLogic.findBoardsByOffset(offset);
    }
}