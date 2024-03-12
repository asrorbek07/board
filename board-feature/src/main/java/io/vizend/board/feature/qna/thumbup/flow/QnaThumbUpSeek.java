/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.qna.thumbup.flow;

import io.vizend.board.feature.action.ThumbUpAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaThumbUpSeek {
    //
    private final ThumbUpAction thumbUpAction;

    public List<ThumbUpRecord> findQnaThumbUps(String sentenceId) {
        //
        return thumbUpAction.findThumbUps(sentenceId);
    }
}
