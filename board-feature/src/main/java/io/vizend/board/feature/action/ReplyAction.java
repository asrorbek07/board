package io.vizend.board.feature.action;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReplyCdo;
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.ReplyLogic;
import io.vizend.board.aggregate.post.domain.logic.ThumbUpRecordLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class ReplyAction {
    //
    private final CommentLogic commentLogic;
    private final ReplyLogic replyLogic;
    private final ThumbUpRecordLogic thumbUpRecordLogic;

    public String registerReply(ReplyCdo replyCdo) {
        //
        String commentId = replyCdo.getCommentId();
        if (commentLogic.existsComment(commentId)) {
            return replyLogic.registerReply(replyCdo);
        } else {
            throw new NoSuchElementException("Comment id: " + commentId);
        }
    }

    public void modifyReply(String replyId, NameValueList nameValueList) {
        //
        replyLogic.modifyReply(replyId, nameValueList);
    }

    public void removeReply(String replyId) {
        //
        for (ThumbUpRecord thumbUpRecord : thumbUpRecordLogic.findAllBySentenceId(replyId)) {
            thumbUpRecordLogic.removeThumbUpRecord(thumbUpRecord.getId());
        }
        replyLogic.removeReply(replyId);
    }


    public List<Reply> findReplies(String commentId) {
        //
        if (commentLogic.existsComment(commentId)) {
            return replyLogic.findReplyByCommentId(commentId);
        }else {

            throw new NoSuchElementException("Comment id: " + commentId);
        }
    }
}
