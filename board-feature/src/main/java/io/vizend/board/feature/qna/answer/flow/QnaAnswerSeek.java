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

import io.vizend.board.feature.action.CommentAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaAnswerSeek {
    //
    private final CommentAction commentAction;

    public Comment findQnaAnswer(String answerId) {
        // 
        return commentAction.findComment(answerId);
    }

    public List<Comment> findQnaAnswers(String questionId) {
        //
        return commentAction.findComments(questionId);
    }
}
