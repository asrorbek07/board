/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.aggregate.board.query;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.board.facade.BoardRole;
import io.vizend.accent.domain.message.DynamicQueryRequest;
import io.vizend.board.aggregate.board.domain.entity.Board;
import org.springframework.data.mongodb.core.MongoTemplate;
import io.vizend.board.aggregate.board.store.mongo.odm.BoardDoc;
import io.vizend.prologue.support.query.mongo.MongoDynamicQuery;
import io.vizend.accent.domain.message.dynamic.DynamicQuery;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(BoardRole.Director)
public class BoardDynamicQuery extends DynamicQueryRequest<Board> {
    /* Gen by Vizend Studio v5.1.0 */

    public void execute(MongoTemplate mongoTemplate) {
        /* Gen by Vizend Studio v5.1.0 */
        DynamicQuery<BoardDoc> query = new MongoDynamicQuery<>(mongoTemplate, getQueryParams(), BoardDoc.class);
        BoardDoc boardDoc = query.findOne();
        setResponse(Optional.ofNullable(boardDoc).map(doc -> doc.toDomain()).orElse(null));
    }
}
