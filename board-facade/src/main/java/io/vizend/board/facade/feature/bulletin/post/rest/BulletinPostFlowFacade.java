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
package io.vizend.board.facade.feature.bulletin.post.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.post.command.RegisterBulletinPostCommand;
import io.vizend.board.facade.feature.bulletin.post.command.ModifyBulletinPostCommand;
import io.vizend.board.facade.feature.bulletin.post.command.RemoveBulletinPostCommand;

public interface BulletinPostFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerBulletinPost(RegisterBulletinPostCommand command);
    CommandResponse modifyBulletinPost(ModifyBulletinPostCommand command);
    CommandResponse removeBulletinPost(RemoveBulletinPostCommand command);
}
