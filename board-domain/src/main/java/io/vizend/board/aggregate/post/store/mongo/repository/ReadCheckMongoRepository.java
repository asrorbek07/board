/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.vizend.board.aggregate.post.store.mongo.odm.ReadCheckDoc;

import java.util.List;
import java.util.Optional;

public interface ReadCheckMongoRepository extends MongoRepository<ReadCheckDoc, String> {
    //
    Optional<ReadCheckDoc> findByPostIdAndReaderId(String postId, String readerId);
    List<ReadCheckDoc> findAllByPostId(String postId);
}
