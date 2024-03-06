/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store;

import io.vizend.board.aggregate.post.domain.entity.Reply;
import java.util.List;

public interface ReplyStore {
    /* Gen by Vizend Studio v5.1.0 */
    void create(Reply reply);
    void createAll(List<Reply> replys);
    Reply retrieve(String id);
    List<Reply> retrieveAll(List<String> replyIds);
    void update(Reply reply);
    void delete(Reply reply);
    void delete(String id);
    boolean exists(String id);
}
