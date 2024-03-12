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

import io.vizend.board.feature.action.ReplyAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinReplySeek {
    //
    private final ReplyAction replyAction;

    public Reply findBulletinReply(String replyId) {
        // 
        return replyAction.findReply(replyId);
    }

    public List<Reply> findBulletinReplies(String commentId) {
        //
        return replyAction.findReplies(commentId);
    }
}
