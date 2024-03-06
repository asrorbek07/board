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
package io.vizend.board.feature.faq.faq.flow;

import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardSequenceCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.board.domain.logic.BoardSequenceLogic;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.feature.faq.faq.domain.sdo.FaqPostCdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqFlow {
    private BoardSequenceLogic boardSequenceLogic; //
    private BoardLogic boardLogic; //
    private PostLogic postLogic; //

    public String registerFAQBoard(BoardCdo boardCdo) {
        //
        BoardSequence faqBoardSequence = boardSequenceLogic.findByEntityName(BoardType.FAQBoard.toString());
        if (faqBoardSequence==null) {
            BoardSequenceCdo boardSequenceCdo = BoardSequenceCdo.builder()
                    .entityName(BoardType.FAQBoard.toString())
                    .build();
            String id = boardSequenceLogic.registerBoardSequence(boardSequenceCdo);
            faqBoardSequence = boardSequenceLogic.findBoardSequence(id);
        }
        long sequence = faqBoardSequence.getSequence();
        boardCdo.setSequence(sequence);
        faqBoardSequence.setSequence(sequence + 1);
        boardSequenceLogic.modifyBoardSequence(faqBoardSequence);
        return boardLogic.registerBoard(boardCdo);
    }

    public String registerFaqPost(FaqPostCdo faqPostCdo) {
        //
        String boardId = faqPostCdo.getBoardId();
        Board board = boardLogic.findBoard(boardId);

        PostCdo postCdo = faqPostCdo.genPostCdo();
        long postSequence = board.getPostSequence();
        postCdo.setSequence(postSequence);

        String postId = postLogic.registerPost(postCdo);

        board.setPostSequence(postSequence + 1);
        boardLogic.modifyBoard(board);
        return postId;
    }
}
