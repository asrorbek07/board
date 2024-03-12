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

package io.vizend.board.feature.notice.board.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.feature.action.BoardAction;
import io.vizend.board.feature.action.PostAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeBoardFlow {
    //
    private final BoardAction boardAction;
    private final PostAction postAction;

    public String registerNoticeBoard(BoardCdo boardCdo) {
        // 
        return boardAction.registerBoard(boardCdo, BoardType.NoticeBoard);
    }

    public void modifyNoticeBoard(String boardId, NameValueList nameValueList) {
        // 
        boardAction.modifyBoard(boardId, nameValueList);
    }

    public void removeNoticeBoard(String boardId) {
        //
        postAction.removePostsByBoardId(boardId);
        boardAction.removeBoard(boardId);
    }
}
