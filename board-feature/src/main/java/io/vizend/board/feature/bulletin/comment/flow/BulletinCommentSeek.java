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

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.action.CommentAction;
import io.vizend.board.feature.action.ThumbUpAction;
import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import io.vizend.board.aggregate.post.domain.entity.Comment;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinCommentSeek {
    //
    private final CommentAction commentAction;
    private final ThumbUpAction thumbUpAction;

    public List<BulletinCommentRdo> findBulletinComments(String postId) {
        // 
        return commentAction.findComments(postId).stream().map(this::getBulletinCommentRdo).collect(Collectors.toList());
    }

    public BulletinCommentRdo findBulletinComment(String commentId) {
        //
        Comment comment = commentAction.findComment(commentId);
        return getBulletinCommentRdo(comment);
    }

    private BulletinCommentRdo getBulletinCommentRdo(Comment comment) {
        //
        List<ThumbUpRecord> thumbUps = thumbUpAction.findThumbUps(comment.getId());
        return BulletinCommentRdo.builder()
                .comment(comment)
                .thumbUps(thumbUps)
                .build();
    }
}
