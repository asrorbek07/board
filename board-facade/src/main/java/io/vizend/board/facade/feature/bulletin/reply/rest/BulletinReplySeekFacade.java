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

import java.util.List;
import io.vizend.board.facade.feature.bulletin.reply.query.FindBulletinRepliesQuery;
import io.vizend.board.feature.bulletin.reply.domain.sdo.BulletinReplyRdo;

public interface BulletinReplySeekFacade {
    //

    QueryResponse<List<BulletinReplyRdo>> findBulletinReplies(FindBulletinRepliesQuery query);
}
