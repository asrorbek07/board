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
package io.vizend.board.feature.qna.question.flow;

import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Post;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaQuestionSeek {
    //
    private final PostLogic postLogic;
    private final BoardLogic boardLogic;

    public Post findQnaQuestion(String questionId) {
        // 
        return postLogic.findPost(questionId);
    }

    public List<Post> findQnaQuestions(String boardId) {
        //
        if (boardLogic.existsBoard(boardId)) {
            return postLogic.findPostsByBoardId(boardId);
        }else {
            throw new NoSuchElementException("Board id: " + boardId);
        }
    }
}
