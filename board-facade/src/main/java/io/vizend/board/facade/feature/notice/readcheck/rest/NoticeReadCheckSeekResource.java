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
package io.vizend.board.facade.feature.notice.readcheck.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.readcheck.flow.NoticeReadCheckSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.facade.feature.notice.readcheck.query.FindNoticeReadChecksQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RestController
@RequestMapping("/feature/notice/readcheck")
@RequiredArgsConstructor
public class NoticeReadCheckSeekResource implements NoticeReadCheckSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final NoticeReadCheckSeek noticeReadCheckSeek;

    @Override
    @PostMapping("/find-notice-read-checks/query")
    public QueryResponse<List<ReadCheck>> findNoticeReadChecks(@RequestBody FindNoticeReadChecksQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String postId = query.getPostId();
        List<ReadCheck> response = noticeReadCheckSeek.findNoticeReadChecks(postId);
        query.setResponse(response);
        return query.getResponse();
    }
}
