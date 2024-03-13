package io.vizend.board.feature.action;

import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.aggregate.post.domain.entity.sdo.ThumbUpRecordCdo;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.aggregate.post.domain.logic.ReplyLogic;
import io.vizend.board.aggregate.post.domain.logic.ThumbUpRecordLogic;
import io.vizend.board.feature.exception.ActionNotAllowedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class ThumbUpAction {
    //
    private final BoardLogic boardLogic;
    private final PostLogic postLogic;
    private final CommentLogic commentLogic;
    private final ReplyLogic replyLogic;
    private final ThumbUpRecordLogic thumbUpRecordLogic;

    public String toggleThumbUp(ThumbUpRecordCdo thumbUpRecordCdo) {
        //
        String sentenceId = thumbUpRecordCdo.getSentenceId();

        validateThumbUp(thumbUpRecordCdo.getSentenceType(), sentenceId);

        String id = thumbUpRecordCdo.getReader().getId();
        String autoId = String.format("%s-%s", sentenceId, id);
        if (thumbUpRecordLogic.existsThumbUpRecord(autoId)){
            thumbUpRecordLogic.removeThumbUpRecord(autoId);
        }else {
            return thumbUpRecordLogic.registerThumbUpRecord(thumbUpRecordCdo);
        }
        return null;
    }

    private void validateThumbUp(SentenceType sentenceType, String sentenceId) {
        boolean isExists=false;
        Board board;
        Post post;
        Comment comment;
        Reply reply;
        switch (sentenceType){
            case Post:
                post = postLogic.findPost(sentenceId);
                if (post!=null) {
                    isExists = true;
                    board = boardLogic.findBoard(post.getBoardId());
                    if (!board.getBoardPolicy().getPostRule().isThumbUp()) {
                        throw new ActionNotAllowedException("ThumbUp is not allowed in this post" + post.getId());
                    }
                }
                break;
            case Comment:
                comment = commentLogic.findComment(sentenceId);
                if (comment!=null){
                    isExists = true;
                    post = postLogic.findPost(comment.getPostId());
                    if (!post.getCommentRule().isThumbUp()){
                        throw new ActionNotAllowedException("ThumbUp is not allowed in this comment" + comment.getId());
                    }
                }
                break;
            case Reply:
                reply = replyLogic.findReply(sentenceId);
                if (reply!=null){
                    isExists =true;
                    comment = commentLogic.findComment(sentenceId);
                    post = postLogic.findPost(comment.getPostId());
                    if (!post.getCommentRule().isThumbUp()){
                        throw new ActionNotAllowedException("ThumbUp is not allowed in this reply" + reply.getId());
                    }
                }
                break;
        }
        if (!isExists){
            throw new NoSuchElementException("Sentence id: " + sentenceId);
        }
    }

    public List<ThumbUpRecord> findThumbUps(String sentenceId) {
        //
        return thumbUpRecordLogic.findAllBySentenceId(sentenceId);
    }
}
