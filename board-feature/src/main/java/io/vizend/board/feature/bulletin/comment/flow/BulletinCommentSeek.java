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

import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.NoSuchElementException;
import io.vizend.board.aggregate.post.domain.entity.Comment;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinCommentSeek {
    //
    private final CommentLogic commentLogic;
    private final PostLogic postLogic;

    public List<Comment> findBulletinComments(String postId) {
        // 
        if (postLogic.existsPost(postId)) {
            return commentLogic.findCommentsByPostId(postId);
        } else {
            throw new NoSuchElementException("Post id: " + postId);
        }
    }

    public Comment findBulletinComment(String commentId) {
        //
        return commentLogic.findComment(commentId);
    }
}
