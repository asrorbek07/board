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

import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;

import io.vizend.board.facade.feature.bulletin.comment.query.FindBulletinCommentsQuery;
import io.vizend.board.facade.feature.bulletin.comment.query.FindBulletinCommentQuery;
import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentRdo;

public interface BulletinCommentSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<List<BulletinCommentRdo>> findBulletinComments(FindBulletinCommentsQuery query);
    QueryResponse<BulletinCommentRdo> findBulletinComment(FindBulletinCommentQuery query);
}
