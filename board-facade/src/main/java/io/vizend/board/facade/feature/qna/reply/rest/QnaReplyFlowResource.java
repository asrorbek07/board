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
package io.vizend.board.facade.feature.qna.reply.rest;

import io.vizend.board.feature.qna.reply.domain.sdo.QnaReplyCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.reply.flow.QnaReplyFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.reply.command.RegisterQnaReplyCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.qna.reply.command.ModifyQnaReplyCommand;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.facade.feature.qna.reply.command.RemoveQnaReplyCommand;

@RestController
@RequestMapping("/feature/qna/reply")
@RequiredArgsConstructor
public class QnaReplyFlowResource implements QnaReplyFlowFacade {
    //
    private final QnaReplyFlow qnaReplyFlow;

    @Override
    @PostMapping("/register-qna-reply/command")
    public CommandResponse registerQnaReply(@RequestBody RegisterQnaReplyCommand command) {
        //
        command.validate();
        QnaReplyCdo qnaReplyCdo = command.genQnaReplyCdo();
        String entityId = qnaReplyFlow.registerQnaReply(qnaReplyCdo.genReplyCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-qna-reply/command")
    public CommandResponse modifyQnaReply(@RequestBody ModifyQnaReplyCommand command) {
        //
        command.validate();
        String replyId = command.getReplyId();
        NameValueList nameValueList = command.getNameValueList();
        qnaReplyFlow.modifyQnaReply(replyId, nameValueList);
        return command.getResponse();

    }

    @Override
    @PostMapping("/remove-qna-reply/command")
    public CommandResponse removeQnaReply(@RequestBody RemoveQnaReplyCommand command) {
        //
        command.validate();
        String replyId = command.getReplyId();
        qnaReplyFlow.removeQnaReply(replyId);
        return command.getResponse();
    }
}
