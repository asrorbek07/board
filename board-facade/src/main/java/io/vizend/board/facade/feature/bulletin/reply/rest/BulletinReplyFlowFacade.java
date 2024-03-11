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
package io.vizend.board.facade.feature.bulletin.reply.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.reply.command.RegisterBulletinReplyCommand;
import io.vizend.board.facade.feature.bulletin.reply.command.ModifyBulletinReplyCommand;
import io.vizend.board.facade.feature.bulletin.reply.command.RemoveBulletinReplyCommand;

public interface BulletinReplyFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerBulletinReply(RegisterBulletinReplyCommand command);
    CommandResponse modifyBulletinReply(ModifyBulletinReplyCommand command);
    CommandResponse removeBulletinReply(RemoveBulletinReplyCommand command);
}
