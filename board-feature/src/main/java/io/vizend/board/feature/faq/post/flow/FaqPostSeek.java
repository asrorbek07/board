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
import io.vizend.board.feature.faq.post.domain.sdo.FaqPostRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Post;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqPostSeek {
    //
    private final PostAction postAction;

    public FaqPostRdo findFaqPost(String postId) {
        //
        Post post = postAction.findPost(postId);
        return getFaqPostRdo(post);
    }

    private FaqPostRdo getFaqPostRdo(Post post) {
        return FaqPostRdo.builder()
                .post(post)
                .build();
    }

    public List<FaqPostRdo> findFaqPosts(String boardId) {
        //
        return postAction.findPosts(boardId).stream().map(this::getFaqPostRdo).collect(Collectors.toList());
    }
}
