/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.vizend.board.aggregate.post.store.ReplyStore;
import io.vizend.board.aggregate.post.store.ReplyOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReplyCdo;
import io.vizend.board.aggregate.post.domain.event.ReplyEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
public class ReplyLogic {
    /* Gen by Vizend Studio v5.1.0 */
    private final ReplyStore replyStore;
    private final ReplyOptionStore replyOptionStore;
    private final EventProxy eventProxy;

    public ReplyLogic(ReplyStore replyStore, ReplyOptionStore replyOptionStore, EventProxy eventProxy) {
        /* Gen by Vizend Studio v5.1.0 */
        this.replyStore = replyStore;
        this.replyOptionStore = replyOptionStore;
        this.eventProxy = eventProxy;
    }

    public String registerReply(ReplyCdo replyCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        Reply reply = new Reply(replyCdo);
        if (replyCdo.hasAdditionalAttributes()) {
            reply.modify(replyCdo.getAdditionalAttributes());
        }
        if (replyStore.exists(reply.getId())) {
            throw new IllegalArgumentException("reply already exists. " + reply.getId());
        }
        replyStore.create(reply);
        ReplyEvent replyEvent = ReplyEvent.newReplyRegisteredEvent(reply, reply.getId());
        eventProxy.publishEvent(replyEvent);
        return reply.getId();
    }

    public List<String> registerReplys(List<ReplyCdo> replyCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        return replyCdos.stream().map(this::registerReply).collect(Collectors.toList());
    }

    public Reply findReply(String replyId) {
        /* Gen by Vizend Studio v5.1.0 */
        Reply reply = replyStore.retrieve(replyId);
        if (reply == null) {
            throw new NoSuchElementException("Reply id: " + replyId);
        }
        return reply;
    }

    public void modifyReply(String replyId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        Reply reply = findReply(replyId);
        reply.modify(nameValues);
        replyStore.update(reply);
        ReplyEvent replyEvent = ReplyEvent.newReplyModifiedEvent(replyId, nameValues, reply);
        eventProxy.publishEvent(replyEvent);
    }

    public void modifyReply(Reply reply) {
        /* Gen by Vizend Studio v5.1.0 */
        Reply oldReply = findReply(reply.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldReply, reply);
        if (nameValues.size() > 0) {
            modifyReply(reply.getId(), nameValues);
        }
    }

    public void removeReply(String replyId) {
        /* Gen by Vizend Studio v5.1.0 */
        Reply reply = findReply(replyId);
        replyStore.delete(reply);
        ReplyEvent replyEvent = ReplyEvent.newReplyRemovedEvent(reply, reply.getId());
        eventProxy.publishEvent(replyEvent);
    }

    public boolean existsReply(String replyId) {
        /* Gen by Vizend Studio v5.1.0 */
        return replyStore.exists(replyId);
    }

    public void handleEventForProjection(ReplyEvent replyEvent) {
        /* Gen by Vizend Studio v5.1.0 */
        switch(replyEvent.getDataEventType()) {
            case Registered:
                replyStore.create(replyEvent.getReply());
                break;
            case Modified:
                Reply reply = replyStore.retrieve(replyEvent.getReplyId());
                reply.modify(replyEvent.getNameValues());
                replyStore.update(reply);
                break;
            case Removed:
                replyStore.delete(replyEvent.getReplyId());
                break;
        }
    }

    public List<Reply> findReplyByCommentId(String commentId) {
        //
        return replyOptionStore.retrieveAllByCommentId(commentId);
    }
}
