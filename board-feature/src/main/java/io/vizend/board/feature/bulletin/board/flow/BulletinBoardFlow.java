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
package io.vizend.board.feature.bulletin.board.flow;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.feature.action.BoardAction;
import io.vizend.board.feature.action.CommentAction;
import io.vizend.board.feature.action.PostAction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BulletinBoardFlow {
    //
    private final BoardAction boardAction;
    private final PostAction postAction;
    private CommentAction commentAction;

    public String registerBulletinBoard(BoardCdo boardCdo) {
        // 
        return boardAction.registerBoard(boardCdo, BoardType.BulletinBoard);
    }


    public void modifyBulletinBoard(String boardId, NameValueList nameValueList) {
        //
        boardAction.modifyBoard(boardId, nameValueList);
    }


    public void removeBulletinBoard(String boardId) {
        //
        for (Post post : postAction.findPosts(boardId)) {
            commentAction.removeCommentsByPostId(post.getId());
            postAction.removePost(post.getId());
        }
        boardAction.removeBoard(boardId);
    }
}
