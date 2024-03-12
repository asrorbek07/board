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

import io.vizend.board.feature.action.CommentAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.Comment;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinCommentSeek {
    //
    private final CommentAction commentAction;

    public List<Comment> findBulletinComments(String postId) {
        // 
        return commentAction.findComments(postId);
    }

    public Comment findBulletinComment(String commentId) {
        //
        return commentAction.findComment(commentId);
    }
}
