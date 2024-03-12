/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store;

import io.vizend.accent.domain.type.IdName;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;

import java.util.List;

public interface ReadCheckOptionStore {
    ReadCheck findByPostIdAndReader(String postId, IdName reader);

    List<ReadCheck> retrieveAllByPostId(String postId);
}
