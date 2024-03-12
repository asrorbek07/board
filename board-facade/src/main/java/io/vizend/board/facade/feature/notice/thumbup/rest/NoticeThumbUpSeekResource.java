/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.thumbup.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.thumbup.flow.NoticeThumbUpSeek;
import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.facade.feature.notice.thumbup.query.FindNoticeThumbUpsQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/notice/thumbup")
@RequiredArgsConstructor
public class NoticeThumbUpSeekResource implements NoticeThumbUpSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final NoticeThumbUpSeek noticeThumbUpSeek;

    @Override
    @PostMapping("/find-notice-thumb-ups/query")
    public QueryResponse<List<ThumbUpRecord>> findNoticeThumbUps(@RequestBody FindNoticeThumbUpsQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String sentenceId = query.getSentenceId();
        List<ThumbUpRecord> response = noticeThumbUpSeek.findNoticeThumbUps(sentenceId);
        query.setResponse(response);
        return query.getResponse();
    }
}
