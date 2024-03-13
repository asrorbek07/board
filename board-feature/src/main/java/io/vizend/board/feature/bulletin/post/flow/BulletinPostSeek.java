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
package io.vizend.board.feature.bulletin.post.flow;

import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.action.PostAction;
import io.vizend.board.feature.action.ReadCheckAction;
import io.vizend.board.feature.action.ThumbUpAction;
import io.vizend.board.feature.bulletin.post.domain.sdo.BulletinPostRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Post;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinPostSeek {
    //
    private final PostAction postAction;
    private final ReadCheckAction readCheckAction;
    private final ThumbUpAction thumbUpAction;

    public BulletinPostRdo findBulletinPost(String postId) {
        // 
        Post post = postAction.findPost(postId);
        readCheckAction.readPost(post);
        return genBulletinPostRdo(post);
    }

    private BulletinPostRdo genBulletinPostRdo(Post post) {
        //
        String questionId = post.getId();
        List<ThumbUpRecord> thumbUps = thumbUpAction.findThumbUps(questionId);
        List<ReadCheck> readChecks = readCheckAction.findReadChecks(questionId);
        return BulletinPostRdo.builder()
                .post(post)
                .thumbUps(thumbUps)
                .readChecks(readChecks)
                .build();
    }

    public List<BulletinPostRdo> findBulletinPosts(String boardId) {
        //
        return postAction.findPosts(boardId).stream().map(this::genBulletinPostRdo).collect(Collectors.toList());
    }
}
