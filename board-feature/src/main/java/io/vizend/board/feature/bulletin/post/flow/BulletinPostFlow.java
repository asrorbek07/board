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
package io.vizend.board.feature.bulletin.post.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.feature.action.CommentAction;
import io.vizend.board.feature.action.PostAction;
import io.vizend.board.feature.action.ReplyAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinPostFlow {
    //
    private final PostAction postAction;
    private final CommentAction commentAction;

    public String registerBulletinPost(PostCdo postCdo) {
        // 
        return postAction.registerPost(postCdo);
    }

    public void modifyBulletinPost(String postId, NameValueList nameValueList) {
        // 
        postAction.modifyPost(postId, nameValueList);
    }

    public void removeBulletinPost(String postId) {
        //
        commentAction.removeCommentsByPostId(postId);
        postAction.removePost(postId);
    }
}
