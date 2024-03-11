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
/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.bulletin.reply.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReplyCdo;
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.ReplyLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinReplyFlow {
    private final CommentLogic commentLogic; // 
    private final ReplyLogic replyLogic;

    public String registerBulletinReply(ReplyCdo replyCdo) {
        // 
        String commentId = replyCdo.getCommentId();
        if (commentLogic.existsComment(commentId)) {
            return replyLogic.registerReply(replyCdo);
        } else {
            throw new NoSuchElementException("Comment id: " + commentId);
        }
    }

    public String modifyBulletinReply(String replyId, NameValueList nameValueList) {
        // 
        replyLogic.modifyReply(replyId, nameValueList);
        return replyId;
    }

    public String removeBulletinReply(String replyId) {
        //
        replyLogic.removeReply(replyId);
        return replyId;
    }
}
