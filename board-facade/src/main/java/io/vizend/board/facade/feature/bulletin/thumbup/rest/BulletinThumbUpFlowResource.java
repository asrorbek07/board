/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.thumbup.rest;

import io.vizend.board.feature.bulletin.thumbup.domain.sdo.BulletinThumbUpRecordCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.thumbup.flow.BulletinThumbUpFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.thumbup.command.ToggleBulletinThumbUpCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/bulletin/thumbup")
@RequiredArgsConstructor
public class BulletinThumbUpFlowResource implements BulletinThumbUpFlowFacade {
    //
    private final BulletinThumbUpFlow bulletinThumbUpFlow;

    @Override
    @PostMapping("/toggle-bulletin-thumb-up/command")
    public CommandResponse toggleBulletinThumbUp(@RequestBody ToggleBulletinThumbUpCommand command) {
        //
        command.validate();
        BulletinThumbUpRecordCdo bulletinThumbUpRecordCdo = command.genBulletinThumbUpRecordCdo();
        String entityId = bulletinThumbUpFlow.toggleBulletinThumbUp(bulletinThumbUpRecordCdo.genThumbUpRecordCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }
}
