/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo;

import org.springframework.stereotype.Repository;
import io.vizend.board.aggregate.post.store.PostStore;
import io.vizend.board.aggregate.post.store.mongo.repository.PostMongoRepository;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.aggregate.post.store.mongo.odm.PostDoc;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Repository
public class PostMongoStore implements PostStore {
    /* Gen by Vizend Studio v5.1.0 */
    private final PostMongoRepository postMongoRepository;

    public PostMongoStore(PostMongoRepository postMongoRepository) {
        /* Gen by Vizend Studio v5.1.0 */
        this.postMongoRepository = postMongoRepository;
    }

    @Override
    public void create(Post post) {
        /* Gen by Vizend Studio v5.1.0 */
        PostDoc postDoc = new PostDoc(post);
        postMongoRepository.save(postDoc);
    }

    @Override
    public void createAll(List<Post> posts) {
        /* Gen by Vizend Studio v5.1.0 */
        if (posts == null) {
            return;
        }
        posts.forEach(this::create);
    }

    @Override
    public Post retrieve(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        Optional<PostDoc> postDoc = postMongoRepository.findById(id);
        return postDoc.map(PostDoc::toDomain).orElse(null);
    }

    @Override
    public List<Post> retrieveAll(List<String> postIds) {
        /* Gen by Vizend Studio v5.1.0 */
        Iterable<PostDoc> allById = postMongoRepository.findAllById(postIds);
        return PostDoc.toDomains(StreamSupport.stream(allById.spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public void update(Post post) {
        /* Gen by Vizend Studio v5.1.0 */
        PostDoc postDoc = new PostDoc(post);
        postMongoRepository.save(postDoc);
    }

    @Override
    public void delete(Post post) {
        /* Gen by Vizend Studio v5.1.0 */
        postMongoRepository.deleteById(post.getId());
    }

    @Override
    public void delete(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        postMongoRepository.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        /* Gen by Vizend Studio v5.1.0 */
        return postMongoRepository.existsById(id);
    }
}
