package io.vizend.board.feature.action;

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.aggregate.post.domain.entity.sdo.ThumbUpRecordCdo;
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.aggregate.post.domain.logic.ReplyLogic;
import io.vizend.board.aggregate.post.domain.logic.ThumbUpRecordLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class ThumbUpAction {
    //
    private final PostLogic postLogic;
    private final CommentLogic commentLogic;
    private final ReplyLogic replyLogic;
    private final ThumbUpRecordLogic thumbUpRecordLogic;

    public String registerThumbUp(ThumbUpRecordCdo thumbUpRecordCdo) {
        //
        boolean isExists=false;
        String sentenceId = thumbUpRecordCdo.getSentenceId();
        switch (thumbUpRecordCdo.getSentenceType()){
            case Post:
                isExists = postLogic.existsPost(sentenceId);
                break;
            case Comment:
                isExists = commentLogic.existsComment(sentenceId);
                break;
            case Reply:
                isExists = replyLogic.existsReply(sentenceId);
                break;
        }
        if (!isExists){
            throw new NoSuchElementException("Sentence id: " + sentenceId);
        }
        String name = thumbUpRecordCdo.getReader().getName();
        String autoId = String.format("%s-%s", sentenceId, name);
        if (thumbUpRecordLogic.existsThumbUpRecord(autoId)){
            thumbUpRecordLogic.removeThumbUpRecord(autoId);
        }else {
            return thumbUpRecordLogic.registerThumbUpRecord(thumbUpRecordCdo);
        }
        return null;
    }

    public void removeThumbUps(String sentenceId){
        for (ThumbUpRecord thumbUp : findThumbUps(sentenceId)) {
            thumbUpRecordLogic.removeThumbUpRecord(thumbUp.getId());
        }
    }

    public List<ThumbUpRecord> findThumbUps(String sentenceId) {
        //
        return thumbUpRecordLogic.findAllBySentenceId(sentenceId);
    }
}
