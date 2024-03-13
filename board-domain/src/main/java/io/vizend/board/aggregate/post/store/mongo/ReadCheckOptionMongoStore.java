/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import io.vizend.accent.domain.type.IdName;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.store.mongo.odm.ReadCheckDoc;
import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.ReadCheckOptionStore;
import io.vizend.board.aggregate.post.store.mongo.repository.ReadCheckMongoRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public class ReadCheckOptionMongoStore implements ReadCheckOptionStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final ReadCheckMongoRepository readCheckMongoRepository;

    public ReadCheckOptionMongoStore(ReadCheckMongoRepository readCheckMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.readCheckMongoRepository = readCheckMongoRepository;
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
    public ReadCheck findByPostIdAndReader(String postId, IdName reader) {
        ReadCheckDoc readCheckDoc = readCheckMongoRepository.findByPostIdAndReaderId(postId, reader.getId()).orElse(null);
        if (readCheckDoc != null) {
            return readCheckDoc.toDomain();
        }
        return null;
    }

    @Override
    public List<ReadCheck> retrieveAllByPostId(String postId) {
        List<ReadCheckDoc> readCheckDocs = readCheckMongoRepository.findAllByPostId(postId);
        return ReadCheckDoc.toDomains(readCheckDocs);
    }
}