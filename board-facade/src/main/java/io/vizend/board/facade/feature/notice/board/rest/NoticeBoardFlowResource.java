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
package io.vizend.board.facade.feature.notice.board.rest;

import io.vizend.board.feature.notice.board.domain.sdo.NoticeBoardCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.board.flow.NoticeBoardFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.notice.board.command.RegisterNoticeBoardCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.facade.feature.notice.board.command.ModifyNoticeBoardCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.notice.board.command.RemoveNoticeBoardCommand;

@RestController
@RequestMapping("/feature/notice/board")
@RequiredArgsConstructor
public class NoticeBoardFlowResource implements NoticeBoardFlowFacade {
    //
    private final NoticeBoardFlow noticeBoardFlow;

    @Override
    @PostMapping("/register-notice-board/command")
    public CommandResponse registerNoticeBoard(@RequestBody RegisterNoticeBoardCommand command) {
        //
        command.validate();
        NoticeBoardCdo noticeBoardCdo = command.genNoticeBoardCdo();
        String entityId = noticeBoardFlow.registerNoticeBoard(noticeBoardCdo.genBoardCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-notice-board/command")
    public CommandResponse modifyNoticeBoard(@RequestBody ModifyNoticeBoardCommand command) {
        //
        command.validate();
        String boardId = command.getBoardId();
        NameValueList nameValueList = command.getNameValueList();
        noticeBoardFlow.modifyNoticeBoard(boardId, nameValueList);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-notice-board/command")
    public CommandResponse removeNoticeBoard(@RequestBody RemoveNoticeBoardCommand command) {
        //
        command.validate();
        String boardId = command.getBoardId();
        noticeBoardFlow.removeNoticeBoard(boardId);
        return command.getResponse();
    }
}
