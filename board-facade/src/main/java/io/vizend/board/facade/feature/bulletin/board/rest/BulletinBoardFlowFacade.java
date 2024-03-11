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

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.board.command.RegisterBulletinBoardCommand;
import io.vizend.board.facade.feature.bulletin.board.command.ModifyBulletinBoardCommand;
import io.vizend.board.facade.feature.bulletin.board.command.RemoveBulletinBoardCommand;

public interface BulletinBoardFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerBulletinBoard(RegisterBulletinBoardCommand command);
    CommandResponse modifyBulletinBoard(ModifyBulletinBoardCommand command);
    CommandResponse removeBulletinBoard(RemoveBulletinBoardCommand command);
}
