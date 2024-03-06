/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.ReplyStore;
import io.vizend.board.aggregate.post.store.mongo.repository.ReplyMongoRepository;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.aggregate.post.store.mongo.odm.ReplyDoc;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Repository
public class ReplyMongoStore implements ReplyStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final ReplyMongoRepository replyMongoRepository;

    public ReplyMongoStore(ReplyMongoRepository replyMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.replyMongoRepository = replyMongoRepository;
    }

    @Override
    public void create(Reply reply) {
        /* Gen by Vizend Studio v5.1.0 */
        ReplyDoc replyDoc = new ReplyDoc(reply);
        replyMongoRepository.save(replyDoc);
    }

    @Override
    public void createAll(List<Reply> replys) {
        /* Gen by Vizend Studio v5.1.0 */
        if (replys == null) {
            return;
        }
        replys.forEach(this::create);
    }

    @Override
    public Reply retrieve(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        Optional<ReplyDoc> replyDoc = replyMongoRepository.findById(id);
        return replyDoc.map(ReplyDoc::toDomain).orElse(null);
    }

    @Override
    public List<Reply> retrieveAll(List<String> replyIds) {
        /* Gen by Vizend Studio v5.1.0 */
        Iterable<ReplyDoc> allById = replyMongoRepository.findAllById(replyIds);
        return ReplyDoc.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public void update(Reply reply) {
        /* Gen by Vizend Studio v5.1.0 */
        ReplyDoc replyDoc = new ReplyDoc(reply);
        replyMongoRepository.save(replyDoc);
    }

    @Override
    public void delete(Reply reply) {
        /* Gen by Vizend Studio v5.1.0 */
        replyMongoRepository.deleteById(reply.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        replyMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        return replyMongoRepository.existsById(id);
    }
}
