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
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class PostEvent extends DataEvent {
    /* Gen by Vizend Studio v5.1.0 */
    private Post post;
    private String postId;
    private NameValueList nameValues;

    protected PostEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Studio v5.1.0 */
        super(type, entity);
    }

    public static PostEvent newPostRegisteredEvent(Post post, String postId) {
        /* Gen by Vizend Studio v5.1.0 */
        PostEvent event = new PostEvent(DataEventType.Registered, post);
        event.setPost(post);
        event.setPostId(postId);
        return event;
    }

    public static PostEvent newPostModifiedEvent(String postId, NameValueList nameValues, Post post) {
        /* Gen by Vizend Studio v5.1.0 */
        PostEvent event = new PostEvent(DataEventType.Modified, post);
        event.setPostId(postId);
        event.setNameValues(nameValues);
        event.setPost(post);
        return event;
    }

    public static PostEvent newPostRemovedEvent(Post post, String postId) {
        /* Gen by Vizend Studio v5.1.0 */
        PostEvent event = new PostEvent(DataEventType.Removed, post);
        event.setPost(post);
        event.setPostId(postId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static PostEvent fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, PostEvent.class);
    }
}
