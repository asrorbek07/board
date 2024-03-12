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
/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.faq.post.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.feature.action.PostAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FaqPostFlow {
    //
    private final PostAction postAction;

    public String registerFaqPost(PostCdo postCdo) {
        // 
        return postAction.registerPost(postCdo);
    }

    public void removeFaqPost(String postId) {
        //
        postAction.removePost(postId);
    }

    public void modifyFaqPost(String postId, NameValueList nameValueList) {
        //
        postAction.modifyPost(postId,nameValueList);
    }
}
