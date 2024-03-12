/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo.repository;

import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import org.springframework.data.mongodb.repository.MongoRepository;
import io.vizend.board.aggregate.board.store.mongo.odm.BoardDoc;

import java.util.List;

public interface BoardMongoRepository extends MongoRepository<BoardDoc, String> {
    //

    List<BoardDoc> findAllByBoardType(BoardType boardType);
    boolean existsByTitle(String title);
}
