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
package io.vizend.board.facade.feature.bulletin.reply.rest;

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.facade.feature.bulletin.reply.query.FindBulletinReplyQuery;
import java.util.List;
import io.vizend.board.facade.feature.bulletin.reply.query.FindBulletinRepliesQuery;

public interface BulletinReplySeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Reply> findBulletinReply(FindBulletinReplyQuery query);
    QueryResponse<List<Reply>> findBulletinReplies(FindBulletinRepliesQuery query);
}
