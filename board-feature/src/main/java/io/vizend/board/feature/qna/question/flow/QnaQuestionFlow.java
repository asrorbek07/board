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
package io.vizend.board.feature.qna.question.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaQuestionFlow {
    private final BoardLogic boardLogic;
    private final PostLogic postLogic;

    public String registerQnaQuestion(PostCdo postCdo) {
        // 
        String boardId = postCdo.getBoardId();
        Board board = boardLogic.findBoard(boardId);
        long postSequence = board.getPostSequence();
        postCdo.setSequence(postSequence);
        if (postCdo.getCommentRule() == null) {
            postCdo.setCommentRule(board.getBoardPolicy().getCommentRule());
        }
        String postId = postLogic.registerPost(postCdo);
        boardLogic.modifyBoard(board.getId(), NameValueList.of("postSequence", String.valueOf(postSequence + 1)));
        return postId;
    }

    public String modifyQnaQuestion(String questionId, NameValueList nameValueList) {
        // 
        postLogic.modifyPost(questionId, nameValueList);
        return questionId;
    }

    public String removeQnaQuestion(String questionId) {
        //
        postLogic.removePost(questionId);
        return questionId;
    }
}
