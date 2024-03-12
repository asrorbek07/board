package io.vizend.board.feature.action;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.entity.vo.ReportOption;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.aggregate.post.domain.logic.ReadCheckLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class PostAction {
    //
    private final BoardLogic boardLogic;
    private final PostLogic postLogic;
    private final ReadCheckLogic readCheckLogic;

    public String registerPost(PostCdo postCdo) {
        //
        if (postLogic.existsPostByTitle(postCdo.getTitle())) {
            throw new IllegalArgumentException("post already exists. " + postCdo.getTitle());
        }
        String boardId = postCdo.getBoardId();
        Board board = boardLogic.findBoard(boardId);
        long postSequence = board.getPostSequence();
        postCdo.setSequence(postSequence);
        if (postCdo.getCommentRule() == null) {
            postCdo.setCommentRule(board.getBoardPolicy().getCommentRule());
        }
        if (postCdo.getReportOption()==null){
            postCdo.setReportOption(ReportOption.sample());
        }
        String postId = postLogic.registerPost(postCdo);
        boardLogic.modifyBoard(board.getId(), NameValueList.of("postSequence", String.valueOf(postSequence + 1)));
        return postId;
    }

    public void modifyPost(String postId, NameValueList nameValueList) {
        //
        postLogic.modifyPost(postId, nameValueList);
    }

    public void removePost(String postId) {
        //
        for (ReadCheck readCheck : readCheckLogic.findReadChecks(postId)) {
            readCheckLogic.removeReadCheck(readCheck.getId());
        }
        postLogic.removePost(postId);
    }
    public void removePostsByBoardId(String boardId){
        for (Post post : findPosts(boardId)) {
            removePost(post.getId());
        }
    }

    public Post findPost(String postId) {
        //
        return postLogic.findPost(postId);
    }

    public List<Post> findPosts(String boardId) {
        //
        if (boardLogic.existsBoard(boardId)) {
            return postLogic.findPostsByBoardId(boardId);
        }
        throw new NoSuchElementException("Board id: " + boardId);
    }
}
