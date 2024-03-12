/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.thumbup.rest;

import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.facade.feature.notice.thumbup.query.FindNoticeThumbUpsQuery;

public interface NoticeThumbUpSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<List<ThumbUpRecord>> findNoticeThumbUps(FindNoticeThumbUpsQuery query);
}
