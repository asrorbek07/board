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
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentCdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinCommentFlow {
    private final PostLogic postLogic; // 
    private final CommentLogic commentLogic;

    public String registerBulletinComment(CommentCdo commentCdo) {
        // 
        String postId = commentCdo.getPostId();
        if (postLogic.existsPost(postId)) {
            return commentLogic.registerComment(commentCdo);
        } else {
            throw new NoSuchElementException("Post id: " + postId);
        }
    }

    public String modifyBulletinComment(String commentId, NameValueList nameValueList) {
        // 
        commentLogic.modifyComment(commentId, nameValueList);
        return commentId;
    }

    public String removeBulletinComment(String commentId) {
        //
        commentLogic.removeComment(commentId);
        return commentId;
    }
}
