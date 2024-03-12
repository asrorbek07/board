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
package io.vizend.board.feature.bulletin.comment.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.sdo.CommentCdo;
import io.vizend.board.feature.action.CommentAction;
import io.vizend.board.feature.action.ReplyAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinCommentFlow {
    //
    private final CommentAction commentAction;
    private final ReplyAction replyAction;

    public String registerBulletinComment(CommentCdo commentCdo) {
        // 
        return commentAction.registerComment(commentCdo);
    }

    public void modifyBulletinComment(String commentId, NameValueList nameValueList) {
        // 
        commentAction.modifyComment(commentId, nameValueList);
    }

    public void removeBulletinComment(String commentId) {
        //
        commentAction.removeComment(commentId);
    }
}
