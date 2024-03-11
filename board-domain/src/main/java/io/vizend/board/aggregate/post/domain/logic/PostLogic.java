/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.logic;

import io.vizend.board.aggregate.board.store.BoardStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.vizend.board.aggregate.post.store.PostStore;
import io.vizend.board.aggregate.post.store.PostOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.event.PostEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.board.aggregate.post.domain.entity.Post;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
public class PostLogic {
    /* Gen by Vizend Studio v5.1.0 */
    private final PostStore postStore;
    private final PostOptionStore postOptionStore;
    private final EventProxy eventProxy;

    public PostLogic(PostStore postStore, PostOptionStore postOptionStore, EventProxy eventProxy) {
        /* Gen by Vizend Studio v5.1.0 */
        this.postStore = postStore;
        this.postOptionStore = postOptionStore;
        this.eventProxy = eventProxy;
    }

    public String registerPost(PostCdo postCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        Post post = new Post(postCdo);
        if (postCdo.hasAdditionalAttributes()) {
            post.modify(postCdo.getAdditionalAttributes());
        }
        if (postStore.exists(post.getId())) {
            throw new IllegalArgumentException("post already exists. " + post.getId());
        }
        postStore.create(post);
        PostEvent postEvent = PostEvent.newPostRegisteredEvent(post, post.getId());
        eventProxy.publishEvent(postEvent);
        return post.getId();
    }

    public List<String> registerPosts(List<PostCdo> postCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        return postCdos.stream().map(this::registerPost).collect(Collectors.toList());
    }

    public Post findPost(String postId) {
        /* Gen by Vizend Studio v5.1.0 */
        Post post = postStore.retrieve(postId);
        if (post == null) {
            throw new NoSuchElementException("Post id: " + postId);
        }
        return post;
    }

    public void modifyPost(String postId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        Post post = findPost(postId);
        post.modify(nameValues);
        postStore.update(post);
        PostEvent postEvent = PostEvent.newPostModifiedEvent(postId, nameValues, post);
        eventProxy.publishEvent(postEvent);
    }

    public void modifyPost(Post post) {
        /* Gen by Vizend Studio v5.1.0 */
        Post oldPost = findPost(post.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldPost, post);
        if (nameValues.size() > 0) {
            modifyPost(post.getId(), nameValues);
        }
    }

    public void removePost(String postId) {
        /* Gen by Vizend Studio v5.1.0 */
        Post post = findPost(postId);
        postStore.delete(post);
        PostEvent postEvent = PostEvent.newPostRemovedEvent(post, post.getId());
        eventProxy.publishEvent(postEvent);
    }

    public boolean existsPost(String postId) {
        /* Gen by Vizend Studio v5.1.0 */
        return postStore.exists(postId);
    }

    public void handleEventForProjection(PostEvent postEvent) {
        /* Gen by Vizend Studio v5.1.0 */
        switch(postEvent.getDataEventType()) {
            case Registered:
                postStore.create(postEvent.getPost());
                break;
            case Modified:
                Post post = postStore.retrieve(postEvent.getPostId());
                post.modify(postEvent.getNameValues());
                postStore.update(post);
                break;
            case Removed:
                postStore.delete(postEvent.getPostId());
                break;
        }
    }

    public List<Post> findPostsByBoardId(String boardId) {

        return postOptionStore.retrieveAllByBoardId(boardId);
    }
}
