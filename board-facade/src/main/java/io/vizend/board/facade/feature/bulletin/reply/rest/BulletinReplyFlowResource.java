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

import io.vizend.board.feature.bulletin.reply.domain.sdo.BulletinReplyCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.bulletin.reply.flow.BulletinReplyFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.bulletin.reply.command.RegisterBulletinReplyCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.bulletin.reply.command.ModifyBulletinReplyCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.bulletin.reply.command.RemoveBulletinReplyCommand;

@RestController
@RequestMapping("/feature/bulletin/reply")
@RequiredArgsConstructor
public class BulletinReplyFlowResource implements BulletinReplyFlowFacade {
    private final BulletinReplyFlow bulletinReplyFlow;

    @Override
    @PostMapping("/register-bulletin-reply/command")
    public CommandResponse registerBulletinReply(@RequestBody RegisterBulletinReplyCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        BulletinReplyCdo bulletinReplyCdo = command.genBulletinReplyCdo();
        String entityId = bulletinReplyFlow.registerBulletinReply(bulletinReplyCdo.genReplyCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-bulletin-reply/command")
    public CommandResponse modifyBulletinReply(@RequestBody ModifyBulletinReplyCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String replyId = command.getReplyId();
        NameValueList nameValueList = command.getNameValueList();
        String entityId = bulletinReplyFlow.modifyBulletinReply(replyId, nameValueList);
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-bulletin-reply/command")
    public CommandResponse removeBulletinReply(@RequestBody RemoveBulletinReplyCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String replyId = command.getReplyId();
        String entityId = bulletinReplyFlow.removeBulletinReply(replyId);
        command.setResponse(entityId);
        return command.getResponse();
    }
}
