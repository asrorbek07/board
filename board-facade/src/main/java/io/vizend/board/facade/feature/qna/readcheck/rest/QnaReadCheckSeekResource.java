/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.readcheck.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.readcheck.flow.QnaReadCheckSeek;
import io.vizend.accent.domain.message.QueryResponse;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.facade.feature.qna.readcheck.query.FindQnaReadChecksQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/qna/readcheck")
@RequiredArgsConstructor
public class QnaReadCheckSeekResource implements QnaReadCheckSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final QnaReadCheckSeek qnaReadCheckSeek;

    @Override
    @PostMapping("/find-qna-read-checks/query")
    public QueryResponse<List<ReadCheck>> findQnaReadChecks(@RequestBody FindQnaReadChecksQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String postId = query.getPostId();
        List<ReadCheck> response = qnaReadCheckSeek.findQnaReadChecks(postId);
        query.setResponse(response);
        return query.getResponse();
    }
}
