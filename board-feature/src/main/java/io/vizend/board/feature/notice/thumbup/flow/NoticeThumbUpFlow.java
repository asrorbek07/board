/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.notice.thumbup.flow;

import io.vizend.board.aggregate.post.domain.entity.sdo.ThumbUpRecordCdo;
import io.vizend.board.feature.action.ThumbUpAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeThumbUpFlow {
    //
    private final ThumbUpAction thumbUpAction;

    public String toggleNoticeThumbUp(ThumbUpRecordCdo thumbUpRecordCdo) {
        //
        return thumbUpAction.toggleThumbUp(thumbUpRecordCdo);
    }
}
