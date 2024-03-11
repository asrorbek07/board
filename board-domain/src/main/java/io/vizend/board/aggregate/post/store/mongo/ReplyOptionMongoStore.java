/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.aggregate.post.store.mongo.odm.ReplyDoc;
import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.ReplyOptionStore;
import io.vizend.board.aggregate.post.store.mongo.repository.ReplyMongoRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public class ReplyOptionMongoStore implements ReplyOptionStore {
    //
    private final ReplyMongoRepository replyMongoRepository;

    public ReplyOptionMongoStore(ReplyMongoRepository replyMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.replyMongoRepository = replyMongoRepository;
    }

    private Pageable createPageable(Offset offset) {
        /* Gen by Vizend Studio v5.1.0 */
        if (offset.getSortDirection() != null && offset.getSortingField() != null) {
            return PageRequest.of(offset.page(), offset.limit(), (offset.ascendingSort() ? Sort.Direction.ASC : Sort.Direction.DESC), offset.getSortingField());
        } else {
            return PageRequest.of(offset.page(), offset.limit());
        }
    }

    @Override
    public List<Reply> retrieveAllByCommentId(String commentId) {
        //
        List<ReplyDoc> replies = replyMongoRepository.findAllByCommentId(commentId);
        return ReplyDoc.toDomains(replies);

    }
}
