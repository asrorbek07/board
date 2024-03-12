/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.thumbup.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.thumbup.flow.QnaThumbUpSeek;
import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.facade.feature.qna.thumbup.query.FindQnaThumbUpsQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/qna/thumbup")
@RequiredArgsConstructor
public class QnaThumbUpSeekResource implements QnaThumbUpSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final QnaThumbUpSeek qnaThumbUpSeek;

    @Override
    @PostMapping("/find-qna-thumb-ups/query")
    public QueryResponse<List<ThumbUpRecord>> findQnaThumbUps(@RequestBody FindQnaThumbUpsQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String sentenceId = query.getSentenceId();
        List<ThumbUpRecord> response = qnaThumbUpSeek.findQnaThumbUps(sentenceId);
        query.setResponse(response);
        return query.getResponse();
    }
}
