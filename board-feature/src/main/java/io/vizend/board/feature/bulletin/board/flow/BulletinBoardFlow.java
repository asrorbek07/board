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
package io.vizend.board.feature.bulletin.board.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardSequenceCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.board.domain.logic.BoardSequenceLogic;
import io.vizend.board.feature.bulletin.board.domain.sdo.BulletinBoardCdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinBoardFlow {
    private final BoardSequenceLogic boardSequenceLogic;
    private BoardLogic boardLogic;

    public String registerBulletinBoard(BoardCdo boardCdo) {
        // 
        BoardSequence faqBoardSequence = getOrCreateBoardSequence();
        long sequence = faqBoardSequence.getSequence();
        boardCdo.setSequence(sequence);
        faqBoardSequence.setSequence(sequence + 1);
        boardSequenceLogic.modifyBoardSequence(faqBoardSequence);
        return boardLogic.registerBoard(boardCdo);
    }

    private BoardSequence getOrCreateBoardSequence() {
        // 
        BoardSequence faqBoardSequence = boardSequenceLogic.findByEntityName(BoardType.BulletinBoard.toString());
        if (faqBoardSequence == null) {
            BoardSequenceCdo boardSequenceCdo = BoardSequenceCdo.builder().entityName(BoardType.BulletinBoard.toString()).build();
            boardSequenceLogic.registerBoardSequence(boardSequenceCdo);
            faqBoardSequence = boardSequenceLogic.findByEntityName(BoardType.BulletinBoard.toString());
        }
        return faqBoardSequence;
    }

    public String modifyBulletinBoard(String boardId, NameValueList nameValueList) {
        // /
        boardLogic.modifyBoard(boardId, nameValueList);
        return boardId;
    }

    public String removeBulletinBoard(String boardId) {
        //
        boardLogic.removeBoard(boardId);
        return boardId;
    }
}
