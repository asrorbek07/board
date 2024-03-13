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

import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.action.PostAction;
import io.vizend.board.feature.action.ReadCheckAction;
import io.vizend.board.feature.action.ThumbUpAction;
import io.vizend.board.feature.qna.question.domain.sdo.QnaQuestionRdo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import io.vizend.board.aggregate.post.domain.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QnaQuestionSeek {
    //
    private final PostAction postAction;
    private final ThumbUpAction thumbUpAction;
    private final ReadCheckAction readCheckAction;

    public QnaQuestionRdo findQnaQuestionRdo(String questionId) {
        //
        Post post = postAction.findPost(questionId);
        QnaQuestionRdo qnaQuestionRdo = genQnaQuestionRdo(post);
        readCheckAction.readPost(post);
        return qnaQuestionRdo;
    }

    private QnaQuestionRdo genQnaQuestionRdo(Post post) {
        //
        String questionId = post.getId();
        List<ThumbUpRecord> thumbUps = thumbUpAction.findThumbUps(questionId);
        List<ReadCheck> readChecks = readCheckAction.findReadChecks(questionId);
        return QnaQuestionRdo.builder()
                .post(post)
                .thumbUps(thumbUps)
                .readChecks(readChecks)
                .build();
    }

    public List<QnaQuestionRdo> findQnaQuestions(String boardId) {
        //
        return postAction.findPosts(boardId).stream().map(this::genQnaQuestionRdo).collect(Collectors.toList());
    }
}
