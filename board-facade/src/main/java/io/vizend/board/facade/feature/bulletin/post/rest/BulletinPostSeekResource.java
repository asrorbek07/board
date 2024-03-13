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
package io.vizend.board.facade.feature.bulletin.post.rest;

import io.vizend.board.feature.bulletin.post.domain.sdo.BulletinPostRdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.post.flow.BulletinPostSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.bulletin.post.query.FindBulletinPostQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.bulletin.post.query.FindBulletinPostsQuery;

@RestController
@RequestMapping("/feature/bulletin/post")
@RequiredArgsConstructor
public class BulletinPostSeekResource implements BulletinPostSeekFacade {
    //
    private final BulletinPostSeek bulletinPostSeek;

    @Override
    @PostMapping("/find-bulletin-post/query")
    public QueryResponse<BulletinPostRdo> findBulletinPost(@RequestBody FindBulletinPostQuery query) {
        //
        query.validate();
        String postId = query.getPostId();
        BulletinPostRdo response = bulletinPostSeek.findBulletinPost(postId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-bulletin-posts/query")
    public QueryResponse<List<BulletinPostRdo>> findBulletinPosts(@RequestBody FindBulletinPostsQuery query) {
        //
        query.validate();
        String boardId = query.getBoardId();
        List<BulletinPostRdo> response = bulletinPostSeek.findBulletinPosts(boardId);
        query.setResponse(response);
        return query.getResponse();
    }
}
