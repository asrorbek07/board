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
package io.vizend.board.facade.feature.qna.thumbup.rest;

import io.vizend.board.feature.qna.thumbup.domain.sdo.QnaThumbUpRecordCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.qna.thumbup.flow.QnaThumbUpFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.qna.thumbup.command.ToggleQnaThumbUpCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/feature/qna/thumbup")
@RequiredArgsConstructor
public class QnaThumbUpFlowResource implements QnaThumbUpFlowFacade {
    //
    private final QnaThumbUpFlow qnaThumbUpFlow;

    @Override
    @PostMapping("/toggle-qna-thumb-up/command")
    public CommandResponse toggleQnaThumbUp(@RequestBody ToggleQnaThumbUpCommand command) {
        //
        command.validate();
        QnaThumbUpRecordCdo qnaThumbUpRecordCdo = command.genQnaThumbUpRecordCdo();
        String entityId = qnaThumbUpFlow.toggleQnaThumbUp(qnaThumbUpRecordCdo.genThumbUpRecordCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }
}
