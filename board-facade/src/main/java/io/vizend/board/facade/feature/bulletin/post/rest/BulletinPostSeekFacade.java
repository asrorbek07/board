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

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.bulletin.post.query.FindBulletinPostQuery;
import java.util.List;
import io.vizend.board.facade.feature.bulletin.post.query.FindBulletinPostsQuery;
import io.vizend.board.feature.bulletin.post.domain.sdo.BulletinPostRdo;

public interface BulletinPostSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<BulletinPostRdo> findBulletinPost(FindBulletinPostQuery query);
    QueryResponse<List<BulletinPostRdo>> findBulletinPosts(FindBulletinPostsQuery query);
}
