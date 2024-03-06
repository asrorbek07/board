/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.CommentStore;
import io.vizend.board.aggregate.post.store.mongo.repository.CommentMongoRepository;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.store.mongo.odm.CommentDoc;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Repository
public class CommentMongoStore implements CommentStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final CommentMongoRepository commentMongoRepository;

    public CommentMongoStore(CommentMongoRepository commentMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.commentMongoRepository = commentMongoRepository;
    }

    @Override
    public void create(Comment comment) {
        /* Gen by Vizend Studio v5.1.0 */
        CommentDoc commentDoc = new CommentDoc(comment);
        commentMongoRepository.save(commentDoc);
    }

    @Override
    public void createAll(List<Comment> comments) {
        /* Gen by Vizend Studio v5.1.0 */
        if (comments == null) {
            return;
        }
        comments.forEach(this::create);
    }

    @Override
    public Comment retrieve(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        Optional<CommentDoc> commentDoc = commentMongoRepository.findById(id);
        return commentDoc.map(CommentDoc::toDomain).orElse(null);
    }

    @Override
    public List<Comment> retrieveAll(List<String> commentIds) {
        /* Gen by Vizend Studio v5.1.0 */
        Iterable<CommentDoc> allById = commentMongoRepository.findAllById(commentIds);
        return CommentDoc.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public void update(Comment comment) {
        /* Gen by Vizend Studio v5.1.0 */
        CommentDoc commentDoc = new CommentDoc(comment);
        commentMongoRepository.save(commentDoc);
    }

    @Override
    public void delete(Comment comment) {
        /* Gen by Vizend Studio v5.1.0 */
        commentMongoRepository.deleteById(comment.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        commentMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        return commentMongoRepository.existsById(id);
    }
}
