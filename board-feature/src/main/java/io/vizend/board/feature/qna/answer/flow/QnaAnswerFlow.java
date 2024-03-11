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
package io.vizend.board.feature.qna.answer.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.sdo.CommentCdo;
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerCdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaAnswerFlow {
    private final PostLogic postLogic; // 
    private final CommentLogic commentLogic;

    public String registerQnaAnswer(CommentCdo commentCdo) {
        // 
        String questionId = commentCdo.getPostId();
        if (postLogic.existsPost(questionId)) {
            return commentLogic.registerComment(commentCdo);
        } else {
            throw new NoSuchElementException("Post id: " + questionId);
        }
    }

    public String modifyQnaAnswer(String answerId, NameValueList nameValueList) {
        // 
        commentLogic.modifyComment(answerId, nameValueList);
        return answerId;
    }

    public String removeQnaAnswer(String answerId) {
        //
        commentLogic.removeComment(answerId);
        return answerId;
    }
}
