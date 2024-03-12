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
package io.vizend.board.feature.faq.post.flow;

import io.vizend.board.feature.action.PostAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Post;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqPostSeek {
    //
    private final PostAction postAction;

    public Post findFaqPost(String postId) {
        //
        return postAction.findPost(postId);
    }

    public List<Post> findFaqPosts(String boardId) {
        //
        return postAction.findPosts(boardId);
    }
}
