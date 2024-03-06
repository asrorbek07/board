/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.vizend.board.aggregate.board.store.mongo.odm.BoardSequenceDoc;

import java.util.Optional;

public interface BoardSequenceMongoRepository extends MongoRepository<BoardSequenceDoc, String> {
    /* Gen by Vizend Studio v5.1.0 */

    Optional<BoardSequenceDoc> findByEntityName(String entityName);
}
