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

import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.ReplyLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinReplySeek {
    private final ReplyLogic replyLogic; // 
    private final CommentLogic commentLogic;

    public Reply findBulletinReply(String replyId) {
        // 
        return replyLogic.findReply(replyId);
    }

    public List<Reply> findBulletinReplies(String commentId) {
        //
        if (commentLogic.existsComment(commentId)) {
            return replyLogic.findReplyByCommentId(commentId);
        }else {

            throw new NoSuchElementException("Comment id: " + commentId);
        }
    }
}
