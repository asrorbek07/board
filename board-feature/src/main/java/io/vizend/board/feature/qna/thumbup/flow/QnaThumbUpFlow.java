/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.qna.thumbup.flow;

import io.vizend.board.aggregate.post.domain.entity.sdo.ThumbUpRecordCdo;
import io.vizend.board.feature.action.ThumbUpAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaThumbUpFlow {
    //
    private final ThumbUpAction thumbUpAction;

    public String registerQnaThumbUp(ThumbUpRecordCdo thumbUpRecordCdo) {
        //
        return thumbUpAction.registerThumbUp(thumbUpRecordCdo);
    }
}
