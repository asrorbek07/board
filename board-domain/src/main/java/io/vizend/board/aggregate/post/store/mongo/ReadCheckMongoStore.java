/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.ReadCheckStore;
import io.vizend.board.aggregate.post.store.mongo.repository.ReadCheckMongoRepository;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.store.mongo.odm.ReadCheckDoc;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Repository
public class ReadCheckMongoStore implements ReadCheckStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final ReadCheckMongoRepository readCheckMongoRepository;

    public ReadCheckMongoStore(ReadCheckMongoRepository readCheckMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.readCheckMongoRepository = readCheckMongoRepository;
    }

    @Override
    public void create(ReadCheck readCheck) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheckDoc readCheckDoc = new ReadCheckDoc(readCheck);
        readCheckMongoRepository.save(readCheckDoc);
    }

    @Override
    public void createAll(List<ReadCheck> readChecks) {
        /* Gen by Vizend Studio v5.1.0 */
        if (readChecks == null) {
            return;
        }
        readChecks.forEach(this::create);
    }

    @Override
    public ReadCheck retrieve(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        Optional<ReadCheckDoc> readCheckDoc = readCheckMongoRepository.findById(id);
        return readCheckDoc.map(ReadCheckDoc::toDomain).orElse(null);
    }

    @Override
    public List<ReadCheck> retrieveAll(List<String> readCheckIds) {
        /* Gen by Vizend Studio v5.1.0 */
        Iterable<ReadCheckDoc> allById = readCheckMongoRepository.findAllById(readCheckIds);
        return ReadCheckDoc.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public void update(ReadCheck readCheck) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheckDoc readCheckDoc = new ReadCheckDoc(readCheck);
        readCheckMongoRepository.save(readCheckDoc);
    }

    @Override
    public void delete(ReadCheck readCheck) {
        /* Gen by Vizend Studio v5.1.0 */
        readCheckMongoRepository.deleteById(readCheck.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        readCheckMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        return readCheckMongoRepository.existsById(id);
    }
}
