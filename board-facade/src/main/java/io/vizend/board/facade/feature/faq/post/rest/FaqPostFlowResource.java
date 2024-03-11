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
package io.vizend.board.facade.feature.faq.post.rest;

import io.vizend.board.feature.faq.post.domain.sdo.FaqPostCdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.faq.post.flow.FaqPostFlow;
import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.faq.post.command.RegisterFaqPostCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import io.vizend.board.facade.feature.faq.post.command.RemoveFaqPostCommand;
import io.vizend.board.facade.feature.faq.post.command.ModifyFaqPostCommand;
import io.vizend.accent.domain.type.NameValueList;

@RestController
@RequestMapping("/feature/faq/post")
@RequiredArgsConstructor
public class FaqPostFlowResource implements FaqPostFlowFacade {
    //
    private final FaqPostFlow faqPostFlow;

    @Override
    @PostMapping("/register-faq-post/command")
    public CommandResponse registerFaqPost(@RequestBody RegisterFaqPostCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        FaqPostCdo faqPostCdo = command.genFaqPostCdo();
        String entityId = faqPostFlow.registerFaqPost(faqPostCdo.genPostCdo());
        command.setResponse(entityId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/remove-faq-post/command")
    public CommandResponse removeFaqPost(@RequestBody RemoveFaqPostCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String postId = command.getPostId();
        faqPostFlow.removeFaqPost(postId);
        return command.getResponse();
    }

    @Override
    @PostMapping("/modify-faq-post/command")
    public CommandResponse modifyFaqPost(@RequestBody ModifyFaqPostCommand command) {
        /* Gen by Vizend Studio v5.1.0 */
        command.validate();
        String postId = command.getPostId();
        NameValueList nameValueList = command.getNameValueList();
        faqPostFlow.modifyFaqPost(postId, nameValueList);

        return command.getResponse();
    }
}
