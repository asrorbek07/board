/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.store.mongo.odm.CommentDoc;
import io.vizend.board.aggregate.post.store.mongo.odm.PostDoc;
import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.CommentOptionStore;
import io.vizend.board.aggregate.post.store.mongo.repository.CommentMongoRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public class CommentOptionMongoStore implements CommentOptionStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final CommentMongoRepository commentMongoRepository;

    public CommentOptionMongoStore(CommentMongoRepository commentMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.commentMongoRepository = commentMongoRepository;
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
    public List<Comment> retrieveAllByPostId(String postId) {
        //
        List<CommentDoc> posts = commentMongoRepository.findAllByPostId(postId);
        return CommentDoc.toDomains(posts);
    }
}
