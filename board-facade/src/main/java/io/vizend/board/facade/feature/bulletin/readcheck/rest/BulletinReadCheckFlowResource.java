/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.readcheck.rest;

import io.vizend.board.feature.bulletin.readcheck.domain.sdo.BulletinReadCheckCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.readcheck.flow.BulletinReadCheckFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.readcheck.command.RegisterBulletinReadCheckCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/bulletin/readcheck")
@RequiredArgsConstructor
public class BulletinReadCheckFlowResource implements BulletinReadCheckFlowFacade {
    //
    private final BulletinReadCheckFlow bulletinReadCheckFlow;

    @Override
    @PostMapping("/register-bulletin-read-check/command")
    public CommandResponse registerBulletinReadCheck(@RequestBody RegisterBulletinReadCheckCommand command) {
        //
        command.validate();
        BulletinReadCheckCdo bulletinReadCheckCdo = command.genBulletinReadCheckCdo();
        String entityId = bulletinReadCheckFlow.registerBulletinReadCheck(bulletinReadCheckCdo.genReadCheckCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }
}
