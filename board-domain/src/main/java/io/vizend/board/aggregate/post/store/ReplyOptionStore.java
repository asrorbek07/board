/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store;

import io.vizend.board.aggregate.post.domain.entity.Reply;

import java.util.List;

public interface ReplyOptionStore {
    List<Reply> retrieveAllByCommentId(String commentId);
}
