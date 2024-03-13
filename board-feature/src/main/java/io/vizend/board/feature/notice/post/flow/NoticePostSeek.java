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
package io.vizend.board.feature.notice.post.flow;

import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.action.PostAction;
import io.vizend.board.feature.action.ReadCheckAction;
import io.vizend.board.feature.action.ThumbUpAction;
import io.vizend.board.feature.notice.post.domain.sdo.NoticePostRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Post;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticePostSeek {
    //
    private final PostAction postAction;
    private final ThumbUpAction thumbUpAction;
    private final ReadCheckAction readCheckAction;

    public NoticePostRdo findNoticePost(String postId) {
        // 
        Post post = postAction.findPost(postId);
        readCheckAction.readPost(post);
        return genNoticePostRdo(post);
    }

    private NoticePostRdo genNoticePostRdo(Post post) {
        //
        String questionId = post.getId();
        List<ThumbUpRecord> thumbUps = thumbUpAction.findThumbUps(questionId);
        List<ReadCheck> readChecks = readCheckAction.findReadChecks(questionId);
        return NoticePostRdo.builder()
                .post(post)
                .thumbUps(thumbUps)
                .readChecks(readChecks)
                .build();
    }

    public List<NoticePostRdo> findNoticePosts(String boardId) {
        //
        return postAction.findPosts(boardId).stream().map(this::genNoticePostRdo).collect(Collectors.toList());
    }
}
