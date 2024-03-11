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
package io.vizend.board.facade.feature.bulletin.comment.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.comment.command.RegisterBulletinCommentCommand;
import io.vizend.board.facade.feature.bulletin.comment.command.ModifyBulletinCommentCommand;
import io.vizend.board.facade.feature.bulletin.comment.command.RemoveBulletinCommentCommand;

public interface BulletinCommentFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerBulletinComment(RegisterBulletinCommentCommand command);
    CommandResponse modifyBulletinComment(ModifyBulletinCommentCommand command);
    CommandResponse removeBulletinComment(RemoveBulletinCommentCommand command);
}
