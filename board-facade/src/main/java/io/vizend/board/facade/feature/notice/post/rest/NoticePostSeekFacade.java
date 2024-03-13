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
package io.vizend.board.facade.feature.notice.post.rest;

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.notice.post.query.FindNoticePostQuery;
import java.util.List;
import io.vizend.board.facade.feature.notice.post.query.FindNoticePostsQuery;
import io.vizend.board.feature.notice.post.domain.sdo.NoticePostRdo;

public interface NoticePostSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<NoticePostRdo> findNoticePost(FindNoticePostQuery query);
    QueryResponse<List<NoticePostRdo>> findNoticePosts(FindNoticePostsQuery query);
}
