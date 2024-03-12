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
import io.vizend.board.feature.action.CommentAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaAnswerFlow {
    //
    private final CommentAction commentAction;

    public String registerQnaAnswer(CommentCdo commentCdo) {
        // 
        return commentAction.registerComment(commentCdo);
    }

    public void modifyQnaAnswer(String answerId, NameValueList nameValueList) {
        // 
        commentAction.modifyComment(answerId, nameValueList);
    }

    public void removeQnaAnswer(String answerId) {
        //
        commentAction.removeComment(answerId);
    }
}
