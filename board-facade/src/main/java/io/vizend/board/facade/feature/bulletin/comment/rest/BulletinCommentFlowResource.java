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

import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.comment.flow.BulletinCommentFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.comment.command.RegisterBulletinCommentCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.bulletin.comment.command.ModifyBulletinCommentCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.bulletin.comment.command.RemoveBulletinCommentCommand;

@RestController
@RequestMapping("/feature/bulletin/comment")
@RequiredArgsConstructor
public class BulletinCommentFlowResource implements BulletinCommentFlowFacade {
    //
    private final BulletinCommentFlow bulletinCommentFlow;

    @Override
    @PostMapping("/register-bulletin-comment/command")
    public CommandResponse registerBulletinComment(@RequestBody RegisterBulletinCommentCommand command) {
        //
        command.validate();
        BulletinCommentCdo bulletinCommentCdo = command.genBulletinCommentCdo();
        String entityId = bulletinCommentFlow.registerBulletinComment(bulletinCommentCdo.genCommentCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-bulletin-comment/command")
    public CommandResponse modifyBulletinComment(@RequestBody ModifyBulletinCommentCommand command) {
        //
        command.validate();
        String commentId = command.getCommentId();
        NameValueList nameValueList = command.getNameValueList();
        bulletinCommentFlow.modifyBulletinComment(commentId, nameValueList);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-bulletin-comment/command")
    public CommandResponse removeBulletinComment(@RequestBody RemoveBulletinCommentCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String commentId = command.getCommentId();
        bulletinCommentFlow.removeBulletinComment(commentId);
        return command.getResponse();
    }
}
