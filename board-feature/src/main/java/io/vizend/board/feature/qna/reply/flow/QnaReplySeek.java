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
package io.vizend.board.feature.qna.reply.flow;

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.action.ReplyAction;
import io.vizend.board.feature.action.ThumbUpAction;
import io.vizend.board.feature.qna.reply.domain.sdo.QnaReplyRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaReplySeek {
    //
    private final ReplyAction replyAction;
    private final ThumbUpAction thumbUpAction;

    private QnaReplyRdo getQnaReplyRdo(Reply reply) {
        List<ThumbUpRecord> thumbUps = thumbUpAction.findThumbUps(reply.getId());
        return QnaReplyRdo.builder()
                .reply(reply)
                .thumbUps(thumbUps)
                .build();
    }

    public List<QnaReplyRdo> findQnaReplies(String commentId) {
        //
        return replyAction.findReplies(commentId).stream().map(this::getQnaReplyRdo).collect(Collectors.toList());
    }
}
