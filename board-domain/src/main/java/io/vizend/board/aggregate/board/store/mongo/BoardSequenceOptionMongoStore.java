/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo;

import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import io.vizend.board.aggregate.board.store.mongo.odm.BoardSequenceDoc;
import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.board.store.BoardSequenceOptionStore;
import io.vizend.board.aggregate.board.store.mongo.repository.BoardSequenceMongoRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Repository
public class BoardSequenceOptionMongoStore implements BoardSequenceOptionStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardSequenceMongoRepository boardSequenceMongoRepository;

    public BoardSequenceOptionMongoStore(BoardSequenceMongoRepository boardSequenceMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardSequenceMongoRepository = boardSequenceMongoRepository;
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
    public BoardSequence retrieveByEntityName(String entityName) {
        Optional<BoardSequenceDoc> boardSequenceDoc = boardSequenceMongoRepository.findByEntityName(entityName);
        return boardSequenceDoc.map(BoardSequenceDoc::toDomain).orElse(null);
    }
}
