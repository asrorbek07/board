/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.reply.rest;

import io.vizend.board.feature.bulletin.reply.domain.sdo.BulletinReplyRdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.reply.flow.BulletinReplySeek;
import io.vizend.accent.domain.message.QueryResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.bulletin.reply.query.FindBulletinRepliesQuery;

@RestController
@RequestMapping("/feature/bulletin/reply")
@RequiredArgsConstructor
public class BulletinReplySeekResource implements BulletinReplySeekFacade {
    //
    private final BulletinReplySeek bulletinReplySeek;

    @Override
    @PostMapping("/find-bulletin-replies/query")
    public QueryResponse<List<BulletinReplyRdo>> findBulletinReplies(@RequestBody FindBulletinRepliesQuery query) {
        //
        query.validate();
        String commentId = query.getCommentId();
        List<BulletinReplyRdo> response = bulletinReplySeek.findBulletinReplies(commentId);
        query.setResponse(response);
        return query.getResponse();
    }
}
