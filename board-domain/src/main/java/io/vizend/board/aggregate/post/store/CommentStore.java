/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store;

import io.vizend.board.aggregate.post.domain.entity.Comment;
import java.util.List;

public interface CommentStore {
    /* Gen by Vizend Studio v5.1.0 */
    void create(Comment comment);
    void createAll(List<Comment> comments);
    Comment retrieve(String id);
    List<Comment> retrieveAll(List<String> commentIds);
    void update(Comment comment);
    void delete(Comment comment);
    void delete(String id);
    boolean exists(String id);
}
