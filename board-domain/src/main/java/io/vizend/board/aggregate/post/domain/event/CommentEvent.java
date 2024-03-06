/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.event;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.message.DataEvent;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class CommentEvent extends DataEvent {
    /* Gen by Vizend Studio v5.1.0 */
    private Comment comment;
    private String commentId;
    private NameValueList nameValues;

    protected CommentEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Studio v5.1.0 */
        super(type, entity);
    }

    public static CommentEvent newCommentRegisteredEvent(Comment comment, String commentId) {
        /* Gen by Vizend Studio v5.1.0 */
        CommentEvent event = new CommentEvent(DataEventType.Registered, comment);
        event.setComment(comment);
        event.setCommentId(commentId);
        return event;
    }

    public static CommentEvent newCommentModifiedEvent(String commentId, NameValueList nameValues, Comment comment) {
        /* Gen by Vizend Studio v5.1.0 */
        CommentEvent event = new CommentEvent(DataEventType.Modified, comment);
        event.setCommentId(commentId);
        event.setNameValues(nameValues);
        event.setComment(comment);
        return event;
    }

    public static CommentEvent newCommentRemovedEvent(Comment comment, String commentId) {
        /* Gen by Vizend Studio v5.1.0 */
        CommentEvent event = new CommentEvent(DataEventType.Removed, comment);
        event.setComment(comment);
        event.setCommentId(commentId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static CommentEvent fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, CommentEvent.class);
    }
}
