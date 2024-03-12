/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.notice.readcheck.flow;

import io.vizend.board.aggregate.post.domain.entity.sdo.ReadCheckCdo;
import io.vizend.board.feature.action.ReadCheckAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeReadCheckFlow {
    //
    private final ReadCheckAction readCheckAction;

    public String registerNoticeReadCheck(ReadCheckCdo readCheckCdo) {
        //
        return readCheckAction.registerReadCheck(readCheckCdo);
    }
}
