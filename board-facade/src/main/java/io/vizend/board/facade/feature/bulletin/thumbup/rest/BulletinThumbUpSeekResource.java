/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.thumbup.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.thumbup.flow.BulletinThumbUpSeek;
import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.facade.feature.bulletin.thumbup.query.FindBulletinThumbUpsQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/bulletin/thumbup")
@RequiredArgsConstructor
public class BulletinThumbUpSeekResource implements BulletinThumbUpSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final BulletinThumbUpSeek bulletinThumbUpSeek;

    @Override
    @PostMapping("/find-bulletin-thumb-ups/query")
    public QueryResponse<List<ThumbUpRecord>> findBulletinThumbUps(@RequestBody FindBulletinThumbUpsQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String sentenceId = query.getSentenceId();
        List<ThumbUpRecord> response = bulletinThumbUpSeek.findBulletinThumbUps(sentenceId);
        query.setResponse(response);
        return query.getResponse();
    }
}
