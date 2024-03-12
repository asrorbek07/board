/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo;

import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.store.mongo.odm.BoardDoc;
import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.board.store.BoardOptionStore;
import io.vizend.board.aggregate.board.store.mongo.repository.BoardMongoRepository;
import org.springframework.data.domain.Pageable;
import io.vizend.accent.domain.type.Offset;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BoardOptionMongoStore implements BoardOptionStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardMongoRepository boardMongoRepository;

    public BoardOptionMongoStore(BoardMongoRepository boardMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardMongoRepository = boardMongoRepository;
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
    public List<Board> retrieveAllByBoardType(BoardType boardType) {
        //
        List<BoardDoc> boardDocs = boardMongoRepository.findAllByBoardType(boardType);
        return boardDocs.stream().map(BoardDoc::toDomain).collect(Collectors.toList());
    }

    @Override
    public boolean existsByTitle(String title) {
        return boardMongoRepository.existsByTitle(title);
    }

}
