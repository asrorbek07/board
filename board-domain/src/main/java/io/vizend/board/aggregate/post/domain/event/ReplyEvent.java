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
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class ReplyEvent extends DataEvent {
    /* Gen by Vizend Studio v5.1.0 */
    private Reply reply;
    private String replyId;
    private NameValueList nameValues;

    protected ReplyEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Studio v5.1.0 */
        super(type, entity);
    }

    public static ReplyEvent newReplyRegisteredEvent(Reply reply, String replyId) {
        /* Gen by Vizend Studio v5.1.0 */
        ReplyEvent event = new ReplyEvent(DataEventType.Registered, reply);
        event.setReply(reply);
        event.setReplyId(replyId);
        return event;
    }

    public static ReplyEvent newReplyModifiedEvent(String replyId, NameValueList nameValues, Reply reply) {
        /* Gen by Vizend Studio v5.1.0 */
        ReplyEvent event = new ReplyEvent(DataEventType.Modified, reply);
        event.setReplyId(replyId);
        event.setNameValues(nameValues);
        event.setReply(reply);
        return event;
    }

    public static ReplyEvent newReplyRemovedEvent(Reply reply, String replyId) {
        /* Gen by Vizend Studio v5.1.0 */
        ReplyEvent event = new ReplyEvent(DataEventType.Removed, reply);
        event.setReply(reply);
        event.setReplyId(replyId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static ReplyEvent fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, ReplyEvent.class);
    }
}
