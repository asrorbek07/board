package io.vizend.board.feature.action;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.type.Offset;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardSequenceCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.board.domain.logic.BoardSequenceLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoardAction {
    //
    private final BoardSequenceLogic boardSequenceLogic;
    private final BoardLogic boardLogic;

    public String registerBoard(BoardCdo boardCdo, BoardType boardType) {
        //
        if (boardLogic.existsBoardByTitle(boardCdo.getTitle())) {
            throw new IllegalArgumentException("board already exists. " + boardCdo.getTitle());
        }else {
            BoardSequence faqBoardSequence = getOrCreateBoardSequence(boardType);
            long sequence = faqBoardSequence.getSequence();
            boardCdo.setSequence(sequence);
            faqBoardSequence.setSequence(sequence + 1);
            boardSequenceLogic.modifyBoardSequence(faqBoardSequence);
            return boardLogic.registerBoard(boardCdo);
        }
    }

    public void modifyBoard(String boardId, NameValueList nameValueList) {
        //
        this.boardLogic.modifyBoard(boardId, nameValueList);
    }

    public void removeBoard(String boardId) {
        //
        this.boardLogic.removeBoard(boardId);
    }

    public Board findBoard(String boardId) {
        //
        return boardLogic.findBoard(boardId);
    }

    public List<Board> findBoardByOffset(Offset offset) {
        //
        return boardLogic.findBoardsByOffset(offset);
    }

    public List<Board> findBoards(BoardType boardType) {
        //
        return boardLogic.findBoardsByType(boardType);
    }

    private BoardSequence getOrCreateBoardSequence(BoardType boardType) {
        //
        BoardSequence faqBoardSequence = boardSequenceLogic.findByEntityName(boardType.toString());
        if (faqBoardSequence == null) {
            BoardSequenceCdo boardSequenceCdo = BoardSequenceCdo.builder().entityName(boardType.toString()).build();
            boardSequenceLogic.registerBoardSequence(boardSequenceCdo);
            faqBoardSequence = boardSequenceLogic.findByEntityName(boardType.toString());
        }
        return faqBoardSequence;
    }
}
