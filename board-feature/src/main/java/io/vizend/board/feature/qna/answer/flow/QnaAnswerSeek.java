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

import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaAnswerSeek {
    private final PostLogic postLogic; // 
    private final CommentLogic commentLogic;

    public Comment findQnaAnswer(String answerId) {
        // 
        return commentLogic.findComment(answerId);
    }

    public List<Comment> findQnaAnswers(String questionId) {
        //
        if (postLogic.existsPost(questionId)) {
            return commentLogic.findCommentsByPostId(questionId);
        }else {
            throw new NoSuchElementException("Post id: " + questionId);
        }
    }
}
