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
package io.vizend.board.feature.bulletin.reply.flow;

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.action.ReplyAction;
import io.vizend.board.feature.action.ThumbUpAction;
import io.vizend.board.feature.bulletin.reply.domain.sdo.BulletinReplyRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinReplySeek {
    //
    private final ReplyAction replyAction;
    private final ThumbUpAction thumbUpAction;

    private BulletinReplyRdo getBulletinReplyRdo(Reply reply) {
        //
        List<ThumbUpRecord> thumbUps = thumbUpAction.findThumbUps(reply.getId());
        return BulletinReplyRdo.builder()
                .reply(reply)
                .thumbUps(thumbUps)
                .build();
    }

    public List<BulletinReplyRdo> findBulletinReplies(String commentId) {
        //
        return replyAction.findReplies(commentId).stream().map(this::getBulletinReplyRdo).collect(Collectors.toList());
    }
}
