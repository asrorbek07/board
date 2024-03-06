/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.faq.faq.flow;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.accent.domain.type.Offset;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqSeek {
    //
    private BoardLogic boardLogic;

    public Page<Board> findFAQBoardsByOffset(String stageId, Offset offset) {
        //
        if (stageId == null) {
            stageId = StageContext.get().getStageId();
        }
        return boardLogic.findBoards(stageId, offset);
    }
}
