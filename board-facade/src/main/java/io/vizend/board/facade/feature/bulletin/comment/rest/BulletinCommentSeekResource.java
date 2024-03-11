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
package io.vizend.board.facade.feature.bulletin.comment.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.comment.flow.BulletinCommentSeek;
import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.facade.feature.bulletin.comment.query.FindBulletinCommentsQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.bulletin.comment.query.FindBulletinCommentQuery;

@RestController
@RequestMapping("/feature/bulletin/comment")
@RequiredArgsConstructor
public class BulletinCommentSeekResource implements BulletinCommentSeekFacade {
    private final BulletinCommentSeek bulletinCommentSeek;

    @Override
    @PostMapping("/find-bulletin-comments/query")
    public QueryResponse<List<Comment>> findBulletinComments(@RequestBody FindBulletinCommentsQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String postId = query.getPostId();
        List<Comment> response = bulletinCommentSeek.findBulletinComments(postId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-bulletin-comment/query")
    public QueryResponse<Comment> findBulletinComment(@RequestBody FindBulletinCommentQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String commentId = query.getCommentId();
        Comment response = bulletinCommentSeek.findBulletinComment(commentId);
        query.setResponse(response);
        return query.getResponse();
    }
}
