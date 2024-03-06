/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.ThumbUpRecordStore;
import io.vizend.board.aggregate.post.store.mongo.repository.ThumbUpRecordMongoRepository;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.aggregate.post.store.mongo.odm.ThumbUpRecordDoc;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Repository
public class ThumbUpRecordMongoStore implements ThumbUpRecordStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final ThumbUpRecordMongoRepository thumbUpRecordMongoRepository;

    public ThumbUpRecordMongoStore(ThumbUpRecordMongoRepository thumbUpRecordMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.thumbUpRecordMongoRepository = thumbUpRecordMongoRepository;
    }

    @Override
    public void create(ThumbUpRecord thumbUpRecord) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecordDoc thumbUpRecordDoc = new ThumbUpRecordDoc(thumbUpRecord);
        thumbUpRecordMongoRepository.save(thumbUpRecordDoc);
    }

    @Override
    public void createAll(List<ThumbUpRecord> thumbUpRecords) {
        /* Gen by Vizend Studio v5.1.0 */
        if (thumbUpRecords == null) {
            return;
        }
        thumbUpRecords.forEach(this::create);
    }

    @Override
    public ThumbUpRecord retrieve(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        Optional<ThumbUpRecordDoc> thumbUpRecordDoc = thumbUpRecordMongoRepository.findById(id);
        return thumbUpRecordDoc.map(ThumbUpRecordDoc::toDomain).orElse(null);
    }

    @Override
    public List<ThumbUpRecord> retrieveAll(List<String> thumbUpRecordIds) {
        /* Gen by Vizend Studio v5.1.0 */
        Iterable<ThumbUpRecordDoc> allById = thumbUpRecordMongoRepository.findAllById(thumbUpRecordIds);
        return ThumbUpRecordDoc.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public void update(ThumbUpRecord thumbUpRecord) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecordDoc thumbUpRecordDoc = new ThumbUpRecordDoc(thumbUpRecord);
        thumbUpRecordMongoRepository.save(thumbUpRecordDoc);
    }

    @Override
    public void delete(ThumbUpRecord thumbUpRecord) {
        /* Gen by Vizend Studio v5.1.0 */
        thumbUpRecordMongoRepository.deleteById(thumbUpRecord.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        thumbUpRecordMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        return thumbUpRecordMongoRepository.existsById(id);
    }
}
