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
package io.vizend.board.feature.qna.board.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardSequenceCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.board.domain.logic.BoardSequenceLogic;
import io.vizend.board.feature.qna.board.domain.sdo.QnaBoardCdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaBoardFlow {
    private final BoardSequenceLogic boardSequenceLogic;
    private final BoardLogic boardLogic;

    public String registerQanBoard(BoardCdo boardCdo) {
        // 
        BoardSequence boardSequence = getOrCreateBoardSequence();
        long sequence = boardSequence.getSequence();
        boardCdo.setSequence(sequence);
        boardSequence.setSequence(sequence + 1);
        boardSequenceLogic.modifyBoardSequence(boardSequence);
        return boardLogic.registerBoard(boardCdo);
    }

    private BoardSequence getOrCreateBoardSequence() {
        // 
        BoardSequence faqBoardSequence = boardSequenceLogic.findByEntityName(BoardType.QNABoard.toString());
        if (faqBoardSequence == null) {
            BoardSequenceCdo boardSequenceCdo = BoardSequenceCdo.builder().entityName(BoardType.QNABoard.toString()).build();
            String id = boardSequenceLogic.registerBoardSequence(boardSequenceCdo);
            faqBoardSequence = boardSequenceLogic.findByEntityName(BoardType.QNABoard.toString());
        }
        return faqBoardSequence;
    }

    public String modifyQanBoard(String boardId, NameValueList nameValueList) {
        // 
        boardLogic.modifyBoard(boardId, nameValueList);
        return boardId;
    }

    public String removeQanBoard(String boardId) {
        // 
        boardLogic.removeBoard(boardId);
        return boardId;
    }
}
