package io.vizend.board.feature.action;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.aggregate.post.domain.entity.sdo.CommentCdo;
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.aggregate.post.domain.logic.ReplyLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class CommentAction {
    //
    private final PostLogic postLogic;
    private final CommentLogic commentLogic;
    private final ReplyLogic replyLogic;

    public String registerComment(CommentCdo commentCdo) {
        //
        String postId = commentCdo.getPostId();
        if (postLogic.existsPost(postId)) {
            return commentLogic.registerComment(commentCdo);
        } else {
            throw new NoSuchElementException("Post id: " + postId);
        }
    }

    public void modifyComment(String commentId, NameValueList nameValueList) {
        //
        commentLogic.modifyComment(commentId, nameValueList);
    }

    public void removeComment(String commentId) {
        //
        for (Reply reply : replyLogic.findReplyByCommentId(commentId)) {
            replyLogic.removeReply(reply.getId());
        }
        commentLogic.removeComment(commentId);
    }

    public void removeCommentsByPostId(String postId){
        List<Comment> comments = findComments(postId);
        for (Comment comment : comments) {
            removeComment(comment.getId());
        }
    }

    public List<Comment> findComments(String postId) {
        //
        if (postLogic.existsPost(postId)) {
            return commentLogic.findCommentsByPostId(postId);
        } else {
            throw new NoSuchElementException("Post id: " + postId);
        }
    }

    public Comment findComment(String commentId) {
        //
        return commentLogic.findComment(commentId);
    }
}
