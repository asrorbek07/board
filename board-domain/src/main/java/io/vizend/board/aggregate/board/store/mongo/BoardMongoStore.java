/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo;

import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.board.store.BoardStore;
import io.vizend.board.aggregate.board.store.mongo.repository.BoardMongoRepository;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.store.mongo.odm.BoardDoc;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Repository
public class BoardMongoStore implements BoardStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardMongoRepository boardMongoRepository;

    public BoardMongoStore(BoardMongoRepository boardMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardMongoRepository = boardMongoRepository;
    }

    @Override
    public void create(Board board) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardDoc boardDoc = new BoardDoc(board);
        boardMongoRepository.save(boardDoc);
    }

    @Override
    public void createAll(List<Board> boards) {
        /* Gen by Vizend Studio v5.1.0 */
        if (boards == null) {
            return;
        }
        boards.forEach(this::create);
    }

    @Override
    public Board retrieve(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        Optional<BoardDoc> boardDoc = boardMongoRepository.findById(id);
        return boardDoc.map(BoardDoc::toDomain).orElse(null);
    }

    @Override
    public List<Board> retrieveAll(List<String> boardIds) {
        /* Gen by Vizend Studio v5.1.0 */
        Iterable<BoardDoc> allById = boardMongoRepository.findAllById(boardIds);
        return BoardDoc.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public void update(Board board) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardDoc boardDoc = new BoardDoc(board);
        boardMongoRepository.save(boardDoc);
    }

    @Override
    public void delete(Board board) {
        /* Gen by Vizend Studio v5.1.0 */
        boardMongoRepository.deleteById(board.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        boardMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardMongoRepository.existsById(id);
    }
}
