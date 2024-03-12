/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.vizend.board.aggregate.post.store.mongo.odm.ThumbUpRecordDoc;

import java.util.List;

public interface ThumbUpRecordMongoRepository extends MongoRepository<ThumbUpRecordDoc, String> {
    //
    List<ThumbUpRecordDoc> findAllBySentenceId(String sentenceId);
}
