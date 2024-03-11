package io.vizend.board.feature.qna.answer.domain.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.domain.entity.sdo.CommentCdo;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnaAnswerCdo extends CreationDataObject {
    //
    private String text;
    private String questionId;

    public static QnaAnswerCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, QnaAnswerCdo.class);
    }

    public static QnaAnswerCdo sample() {
        //
        CommentCdo sample = CommentCdo.sample();
        return QnaAnswerCdo
                .builder()
                .text(sample.getText())
                .questionId(sample.getPostId())
                .build();
    }

    public CommentCdo genCommentCdo(){
        //
        return CommentCdo.builder()
                .text(text)
                .displayName(StageContext.get().getDisplayName())
                .postId(questionId)
                .accepted(false)
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return CommentCdo.sample().genId();
    }

    public String toString() {
        //
        return toJson();
    }
}
