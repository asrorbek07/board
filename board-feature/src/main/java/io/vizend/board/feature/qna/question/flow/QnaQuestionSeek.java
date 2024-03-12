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
import io.vizend.board.feature.action.PostAction;
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
    private final PostAction postAction;

    public Post findQnaQuestion(String questionId) {
        // 
        return postAction.findPost(questionId);
    }

    public List<Post> findQnaQuestions(String boardId) {
        //
        return postAction.findPosts(boardId);
    }
}
