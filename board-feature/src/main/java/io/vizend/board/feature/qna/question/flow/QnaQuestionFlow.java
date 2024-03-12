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
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.feature.action.CommentAction;
import io.vizend.board.feature.action.PostAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaQuestionFlow {
    //
    private final PostAction postAction;
    private final CommentAction commentAction;

    public String registerQnaQuestion(PostCdo postCdo) {
        // 
        return postAction.registerPost(postCdo);
    }

    public void modifyQnaQuestion(String questionId, NameValueList nameValueList) {
        // 
        postAction.modifyPost(questionId, nameValueList);
    }

    public void removeQnaQuestion(String questionId) {
        //
        commentAction.removeCommentsByPostId(questionId);
        postAction.removePost(questionId);
    }
}
