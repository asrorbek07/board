/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.readcheck.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.readcheck.flow.BulletinReadCheckSeek;
import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.facade.feature.bulletin.readcheck.query.FindBulletinReadChecksQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/bulletin/readcheck")
@RequiredArgsConstructor
public class BulletinReadCheckSeekResource implements BulletinReadCheckSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final BulletinReadCheckSeek bulletinReadCheckSeek;

    @Override
    @PostMapping("/find-bulletin-read-checks/query")
    public QueryResponse<List<ReadCheck>> findBulletinReadChecks(@RequestBody FindBulletinReadChecksQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String postId = query.getPostId();
        List<ReadCheck> response = bulletinReadCheckSeek.findBulletinReadChecks(postId);
        query.setResponse(response);
        return query.getResponse();
    }
}
