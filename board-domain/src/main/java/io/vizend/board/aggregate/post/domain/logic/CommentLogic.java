/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.vizend.board.aggregate.post.store.CommentStore;
import io.vizend.board.aggregate.post.store.CommentOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.board.aggregate.post.domain.entity.sdo.CommentCdo;
import io.vizend.board.aggregate.post.domain.event.CommentEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
public class CommentLogic {
    /* Gen by Vizend Studio v5.1.0 */
    private final CommentStore commentStore;
    private final CommentOptionStore commentOptionStore;
    private final EventProxy eventProxy;

    public CommentLogic(CommentStore commentStore, CommentOptionStore commentOptionStore, EventProxy eventProxy) {
        /* Gen by Vizend Studio v5.1.0 */
        this.commentStore = commentStore;
        this.commentOptionStore = commentOptionStore;
        this.eventProxy = eventProxy;
    }

    public String registerComment(CommentCdo commentCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        Comment comment = new Comment(commentCdo);
        if (commentCdo.hasAdditionalAttributes()) {
            comment.modify(commentCdo.getAdditionalAttributes());
        }
        if (commentStore.exists(comment.getId())) {
            throw new IllegalArgumentException("comment already exists. " + comment.getId());
        }
        commentStore.create(comment);
        CommentEvent commentEvent = CommentEvent.newCommentRegisteredEvent(comment, comment.getId());
        eventProxy.publishEvent(commentEvent);
        return comment.getId();
    }

    public List<String> registerComments(List<CommentCdo> commentCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        return commentCdos.stream().map(this::registerComment).collect(Collectors.toList());
    }

    public Comment findComment(String commentId) {
        /* Gen by Vizend Studio v5.1.0 */
        Comment comment = commentStore.retrieve(commentId);
        if (comment == null) {
            throw new NoSuchElementException("Comment id: " + commentId);
        }
        return comment;
    }

    public void modifyComment(String commentId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        Comment comment = findComment(commentId);
        comment.modify(nameValues);
        commentStore.update(comment);
        CommentEvent commentEvent = CommentEvent.newCommentModifiedEvent(commentId, nameValues, comment);
        eventProxy.publishEvent(commentEvent);
    }

    public void modifyComment(Comment comment) {
        /* Gen by Vizend Studio v5.1.0 */
        Comment oldComment = findComment(comment.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldComment, comment);
        if (nameValues.size() > 0) {
            modifyComment(comment.getId(), nameValues);
        }
    }

    public void removeComment(String commentId) {
        /* Gen by Vizend Studio v5.1.0 */
        Comment comment = findComment(commentId);
        commentStore.delete(comment);
        CommentEvent commentEvent = CommentEvent.newCommentRemovedEvent(comment, comment.getId());
        eventProxy.publishEvent(commentEvent);
    }

    public boolean existsComment(String commentId) {
        /* Gen by Vizend Studio v5.1.0 */
        return commentStore.exists(commentId);
    }

    public void handleEventForProjection(CommentEvent commentEvent) {
        /* Gen by Vizend Studio v5.1.0 */
        switch(commentEvent.getDataEventType()) {
            case Registered:
                commentStore.create(commentEvent.getComment());
                break;
            case Modified:
                Comment comment = commentStore.retrieve(commentEvent.getCommentId());
                comment.modify(commentEvent.getNameValues());
                commentStore.update(comment);
                break;
            case Removed:
                commentStore.delete(commentEvent.getCommentId());
                break;
        }
    }

    public List<Comment> findCommentsByPostId(String postId) {
        //
        return commentOptionStore.retrieveAllByPostId(postId);
    }
}
