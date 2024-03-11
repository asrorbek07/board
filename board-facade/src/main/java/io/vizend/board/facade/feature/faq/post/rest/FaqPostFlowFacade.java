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

import io.vizend.accent.domain.message.CommandResponse;
import io.vizend.board.facade.feature.faq.post.command.RegisterFaqPostCommand;
import io.vizend.board.facade.feature.faq.post.command.RemoveFaqPostCommand;
import io.vizend.board.facade.feature.faq.post.command.ModifyFaqPostCommand;

public interface FaqPostFlowFacade {
    /* Gen by Vizend Studio v5.1.0 */
    CommandResponse registerFaqPost(RegisterFaqPostCommand command);
    CommandResponse removeFaqPost(RemoveFaqPostCommand command);
    CommandResponse modifyFaqPost(ModifyFaqPostCommand command);
}
