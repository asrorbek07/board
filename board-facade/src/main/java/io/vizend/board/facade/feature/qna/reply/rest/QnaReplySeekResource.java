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
package io.vizend.board.facade.feature.qna.reply.rest;

import io.vizend.board.feature.qna.reply.domain.sdo.QnaReplyRdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.reply.flow.QnaReplySeek;
import io.vizend.accent.domain.message.QueryResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.qna.reply.query.FindQnaRepliesQuery;

@RestController
@RequestMapping("/feature/qna/reply")
@RequiredArgsConstructor
public class QnaReplySeekResource implements QnaReplySeekFacade {
    //
    private final QnaReplySeek qnaReplySeek;

    @Override
    @PostMapping("/find-qna-replies/query")
    public QueryResponse<List<QnaReplyRdo>> findQnaReplies(@RequestBody FindQnaRepliesQuery query) {
        //
        query.validate();
        String commentId = query.getCommentId();
        List<QnaReplyRdo> response = qnaReplySeek.findQnaReplies(commentId);
        query.setResponse(response);
        return query.getResponse();
    }
}
