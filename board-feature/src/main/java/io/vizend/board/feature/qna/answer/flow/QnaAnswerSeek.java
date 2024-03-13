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

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.action.CommentAction;
import io.vizend.board.feature.action.ThumbUpAction;
import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaAnswerSeek {
    //
    private final CommentAction commentAction;
    private final ThumbUpAction thumbUpAction;

    public QnaAnswerRdo findQnaAnswer(String answerId) {
        // 
        Comment comment = commentAction.findComment(answerId);
        return genQnaAnswerRdo(comment);
    }

    private QnaAnswerRdo genQnaAnswerRdo(Comment comment) {
        //
        List<ThumbUpRecord> thumbUps = thumbUpAction.findThumbUps(comment.getId());
        return QnaAnswerRdo.builder()
                .comment(comment)
                .thumbUps(thumbUps)
                .build();
    }

    public List<QnaAnswerRdo> findQnaAnswers(String questionId) {
        //
        return commentAction.findComments(questionId).stream().map(this::genQnaAnswerRdo).collect(Collectors.toList());
    }
}
