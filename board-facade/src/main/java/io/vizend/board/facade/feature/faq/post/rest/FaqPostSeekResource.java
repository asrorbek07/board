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

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.faq.post.flow.FaqPostSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.faq.post.query.FindFaqPostQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.faq.post.query.FindFaqPostsByBoardIdQuery;

@RestController
@RequestMapping("/feature/faq/post")
@RequiredArgsConstructor
public class FaqPostSeekResource implements FaqPostSeekFacade {
    //
    private final FaqPostSeek faqPostSeek;

    @Override
    @PostMapping("/find-faq-post/query")
    public QueryResponse<Post> findFaqPost(@RequestBody FindFaqPostQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String postId = query.getPostId();
        Post response = faqPostSeek.findFaqPost(postId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-faq-posts-by-board-id/query")
    public QueryResponse<List<Post>> findFaqPostsByBoardId(@RequestBody FindFaqPostsByBoardIdQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String boardId = query.getBoardId();
        List<Post> response = faqPostSeek.findFaqPostsByBoardId(boardId);
        query.setResponse(response);
        return query.getResponse();
    }
}
