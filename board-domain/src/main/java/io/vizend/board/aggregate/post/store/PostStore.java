/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store;

import io.vizend.board.aggregate.post.domain.entity.Post;
import java.util.List;

public interface PostStore {
    /* Gen by Vizend Studio v5.1.0 */
    void create(Post post);
    void createAll(List<Post> posts);
    Post retrieve(String id);
    List<Post> retrieveAll(List<String> postIds);
    void update(Post post);
    void delete(Post post);
    void delete(String id);
    boolean exists(String id);
}
