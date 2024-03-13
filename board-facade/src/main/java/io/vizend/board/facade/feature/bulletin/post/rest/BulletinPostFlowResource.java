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

import io.vizend.board.feature.bulletin.post.domain.sdo.BulletinPostCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.post.flow.BulletinPostFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.post.command.RegisterBulletinPostCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.bulletin.post.command.ModifyBulletinPostCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.bulletin.post.command.RemoveBulletinPostCommand;

@RestController
@RequestMapping("/feature/bulletin/post")
@RequiredArgsConstructor
public class BulletinPostFlowResource implements BulletinPostFlowFacade {
    //
    private final BulletinPostFlow bulletinPostFlow;

    @Override
    @PostMapping("/register-bulletin-post/command")
    public CommandResponse registerBulletinPost(@RequestBody RegisterBulletinPostCommand command) {
        //
        BulletinPostCdo bulletinPostCdo = command.genBulletinPostCdo();
        String entityId = bulletinPostFlow.registerBulletinPost(bulletinPostCdo.genPostCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-bulletin-post/command")
    public CommandResponse modifyBulletinPost(@RequestBody ModifyBulletinPostCommand command) {
        //
        command.validate();
        String postId = command.getPostId();
        NameValueList nameValueList = command.getNameValueList();
        bulletinPostFlow.modifyBulletinPost(postId, nameValueList);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-bulletin-post/command")
    public CommandResponse removeBulletinPost(@RequestBody RemoveBulletinPostCommand command) {
        //
        command.validate();
        String postId = command.getPostId();
        bulletinPostFlow.removeBulletinPost(postId);
        return command.getResponse();
    }
}
