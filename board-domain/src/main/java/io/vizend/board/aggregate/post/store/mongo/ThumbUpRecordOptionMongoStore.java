/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.aggregate.post.store.mongo.odm.ThumbUpRecordDoc;
import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.ThumbUpRecordOptionStore;
import io.vizend.board.aggregate.post.store.mongo.repository.ThumbUpRecordMongoRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public class ThumbUpRecordOptionMongoStore implements ThumbUpRecordOptionStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final ThumbUpRecordMongoRepository thumbUpRecordMongoRepository;

    public ThumbUpRecordOptionMongoStore(ThumbUpRecordMongoRepository thumbUpRecordMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.thumbUpRecordMongoRepository = thumbUpRecordMongoRepository;
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
    public List<ThumbUpRecord> retrieveAllBySentenceId(String sentenceId) {
        //
        List<ThumbUpRecordDoc> thumbUpRecordDocs = thumbUpRecordMongoRepository.findAllBySentenceId(sentenceId);
        return ThumbUpRecordDoc.toDomains(thumbUpRecordDocs);
    }
}
