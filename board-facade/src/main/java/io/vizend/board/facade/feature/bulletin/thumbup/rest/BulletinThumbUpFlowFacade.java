/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.thumbup.rest;

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.thumbup.command.ToggleBulletinThumbUpCommand;

public interface BulletinThumbUpFlowFacade {
    //
    CommandResponse toggleBulletinThumbUp(ToggleBulletinThumbUpCommand command);
}
