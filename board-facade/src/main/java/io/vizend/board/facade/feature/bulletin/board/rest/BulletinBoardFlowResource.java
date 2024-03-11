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
package io.vizend.board.facade.feature.bulletin.board.rest;

import io.vizend.board.feature.bulletin.board.domain.sdo.BulletinBoardCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.board.flow.BulletinBoardFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.board.command.RegisterBulletinBoardCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.facade.feature.bulletin.board.command.ModifyBulletinBoardCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.bulletin.board.command.RemoveBulletinBoardCommand;

@RestController
@RequestMapping("/feature/bulletin/board")
@RequiredArgsConstructor
public class BulletinBoardFlowResource implements BulletinBoardFlowFacade {
    private final BulletinBoardFlow bulletinBoardFlow;

    @Override
    @PostMapping("/register-bulletin-board/command")
    public CommandResponse registerBulletinBoard(@RequestBody RegisterBulletinBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        BulletinBoardCdo bulletinBoardCdo = command.genBulletinBoardCdo();
        String entityId = bulletinBoardFlow.registerBulletinBoard(bulletinBoardCdo.genBoardCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-bulletin-board/command")
    public CommandResponse modifyBulletinBoard(@RequestBody ModifyBulletinBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String boardId = command.getBoardId();
        NameValueList nameValueList = command.getNameValueList();
        String entityId = bulletinBoardFlow.modifyBulletinBoard(boardId, nameValueList);
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-bulletin-board/command")
    public CommandResponse removeBulletinBoard(@RequestBody RemoveBulletinBoardCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String boardId = command.getBoardId();
        String entityId = bulletinBoardFlow.removeBulletinBoard(boardId);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
