package io.vizend.board.feature.qna.question.domain.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.entity.vo.ReportOption;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnaQuestionCdo extends CreationDataObject {
    //
    private String title;
    private String content;
    private String boardId;
    private ReportOption reportOption;
    private CommentRule commentRule;

    public static QnaQuestionCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, QnaQuestionCdo.class);
    }

    public static QnaQuestionCdo sample() {
        //
        PostCdo postCdoSample = PostCdo.sample();
        return QnaQuestionCdo
                .builder()
                .title(postCdoSample.getTitle())
                .content(postCdoSample.getContent())
                .boardId(postCdoSample.getBoardId())
                .reportOption(postCdoSample.getReportOption())
                .commentRule(postCdoSample.getCommentRule())
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    public String toString() {
        //
        return toJson();
    }

    public PostCdo genPostCdo(){
        //
        return PostCdo
                .builder()
                .title(title)
                .displayName(StageContext.get().getDisplayName())
                .content(content)
                .boardId(boardId)
                .reportOption(reportOption)
                .commentRule(commentRule)
                .build();
    }

    @Override
    public String genId() {

        return PostCdo.sample().genId();
    }
}
