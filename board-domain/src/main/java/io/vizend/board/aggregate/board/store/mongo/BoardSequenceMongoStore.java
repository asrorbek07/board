/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo;

import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.board.store.BoardSequenceStore;
import io.vizend.board.aggregate.board.store.mongo.repository.BoardSequenceMongoRepository;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import io.vizend.board.aggregate.board.store.mongo.odm.BoardSequenceDoc;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Repository
public class BoardSequenceMongoStore implements BoardSequenceStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardSequenceMongoRepository boardSequenceMongoRepository;

    public BoardSequenceMongoStore(BoardSequenceMongoRepository boardSequenceMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardSequenceMongoRepository = boardSequenceMongoRepository;
    }

    @Override
    public void create(BoardSequence boardSequence) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequenceDoc boardSequenceDoc = new BoardSequenceDoc(boardSequence);
        boardSequenceMongoRepository.save(boardSequenceDoc);
    }

    @Override
    public void createAll(List<BoardSequence> boardSequences) {
        /* Gen by Vizend Studio v5.1.0 */
        if (boardSequences == null) {
            return;
        }
        boardSequences.forEach(this::create);
    }

    @Override
    public BoardSequence retrieve(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        Optional<BoardSequenceDoc> boardSequenceDoc = boardSequenceMongoRepository.findById(id);
        return boardSequenceDoc.map(BoardSequenceDoc::toDomain).orElse(null);
    }

    @Override
    public List<BoardSequence> retrieveAll(List<String> boardSequenceIds) {
        /* Gen by Vizend Studio v5.1.0 */
        Iterable<BoardSequenceDoc> allById = boardSequenceMongoRepository.findAllById(boardSequenceIds);
        return BoardSequenceDoc.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public void update(BoardSequence boardSequence) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequenceDoc boardSequenceDoc = new BoardSequenceDoc(boardSequence);
        boardSequenceMongoRepository.save(boardSequenceDoc);
    }

    @Override
    public void delete(BoardSequence boardSequence) {
        /* Gen by Vizend Studio v5.1.0 */
        boardSequenceMongoRepository.deleteById(boardSequence.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        boardSequenceMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardSequenceMongoRepository.existsById(id);
    }
}
