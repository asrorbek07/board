/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.aggregate.post.store.mongo.odm.PostDoc;
import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.PostOptionStore;
import io.vizend.board.aggregate.post.store.mongo.repository.PostMongoRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostOptionMongoStore implements PostOptionStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final PostMongoRepository postMongoRepository;

    public PostOptionMongoStore(PostMongoRepository postMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.postMongoRepository = postMongoRepository;
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
    public List<Post> retrieveAllByBoardId(String boardId) {
        List<PostDoc> postDocs = postMongoRepository.findAllByBoardId(boardId);
        return postDocs.stream().map(PostDoc::toDomain).collect(Collectors.toList());

    }

    @Override
    public boolean existsByTitle(String title) {
        return postMongoRepository.existsByTitle(title);
    }
}
