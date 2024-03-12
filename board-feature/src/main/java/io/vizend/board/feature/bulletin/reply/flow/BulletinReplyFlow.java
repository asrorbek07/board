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
import io.vizend.board.feature.action.ReplyAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinReplyFlow {
    //
    private final ReplyAction replyAction;

    public String registerBulletinReply(ReplyCdo replyCdo) {
        // 
        return replyAction.registerReply(replyCdo);
    }

    public void modifyBulletinReply(String replyId, NameValueList nameValueList) {
        // 
        replyAction.modifyReply(replyId, nameValueList);
    }

    public void removeBulletinReply(String replyId) {
        //
        replyAction.removeReply(replyId);
    }
}
