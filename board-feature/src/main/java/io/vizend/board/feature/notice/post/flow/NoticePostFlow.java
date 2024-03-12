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
package io.vizend.board.feature.notice.post.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.feature.action.PostAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticePostFlow {
    //
    private final PostAction postAction;

    public String registerNoticePost(PostCdo postCdo) {
        // 
        return postAction.registerPost(postCdo);
    }

    public void modifyNoticePost(String postId, NameValueList nameValueList) {
        // 
        postAction.modifyPost(postId, nameValueList);
    }

    public void removeNoticePost(String postId) {
        //
        postAction.removePost(postId);
    }
}
