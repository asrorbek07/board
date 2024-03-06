/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.faq.rest;

import io.vizend.board.feature.faq.faq.flow.FaqSeek;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.accent.domain.message.QueryResponse;
import org.springframework.data.domain.Page;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.facade.feature.faq.faq.query.FindFAQBoardsByOffsetQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.accent.domain.type.Offset;

@RestController
@RequestMapping("/feature/faq/faq")
@RequiredArgsConstructor
public class FaqSeekResource implements FaqSeekFacade {
    /* Gen by Vizend Studio v5.1.0 */
    private final FaqSeek faqSeek;

    @Override
    @PostMapping("/find-f-a-q-boards-by-offset/query")
    public QueryResponse<Page<Board>> findFAQBoardsByOffset(@RequestBody FindFAQBoardsByOffsetQuery query) {
        /* Gen by Vizend Studio v5.1.0 */
        query.validate();
        String stageId = query.getStageId();
        Offset offset = query.getOffset();
        Page<Board> response = faqSeek.findFAQBoardsByOffset(stageId, offset);
        query.setResponse(response);
        return query.getResponse();
    }
}
