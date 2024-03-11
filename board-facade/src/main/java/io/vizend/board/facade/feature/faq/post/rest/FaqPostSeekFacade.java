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
package io.vizend.board.facade.feature.faq.post.rest;

import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.faq.post.query.FindFaqPostQuery;
import java.util.List;
import io.vizend.board.facade.feature.faq.post.query.FindFaqPostsByBoardIdQuery;

public interface FaqPostSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    QueryResponse<Post> findFaqPost(FindFaqPostQuery query);
    QueryResponse<List<Post>> findFaqPostsByBoardId(FindFaqPostsByBoardIdQuery query);
}
