/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo.repository;

import io.vizend.board.aggregate.post.domain.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import io.vizend.board.aggregate.post.store.mongo.odm.CommentDoc;

import java.util.List;

public interface CommentMongoRepository extends MongoRepository<CommentDoc, String> {
    //
    List<CommentDoc> findAllByPostId(String postId);
}
