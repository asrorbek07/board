/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.notice.thumbup.flow;

import io.vizend.board.feature.action.ThumbUpAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeThumbUpSeek {
    //
    private final ThumbUpAction thumbUpAction;

    public List<ThumbUpRecord> findNoticeThumbUps(String sentenceId) {
        //
        return thumbUpAction.findThumbUps(sentenceId);
    }
}
