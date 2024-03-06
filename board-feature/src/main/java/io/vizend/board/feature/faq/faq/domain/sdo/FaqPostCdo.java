package io.vizend.board.feature.faq.faq.domain.sdo;

import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.entity.vo.ReportOption;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FaqPostCdo extends CreationDataObject {
    //
    private String title;
    private String displayName;
    private String content;
    private String boardId;
    private CommentRule commentRule;
    private ReportOption reportOption;

    public static FaqPostCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, FaqPostCdo.class);
    }

    public static FaqPostCdo sample() {
        //
        PostCdo postCdoSample = PostCdo.sample();
        return FaqPostCdo
                .builder()
                .title(postCdoSample.getTitle())
                .displayName(postCdoSample.getDisplayName())
                .content(postCdoSample.getContent())
                .boardId(postCdoSample.getBoardId())
                .commentRule(postCdoSample.getCommentRule())
                .reportOption(postCdoSample.getReportOption())
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
                .displayName(displayName)
                .content(content)
                .boardId(boardId)
                .commentRule(commentRule)
                .reportOption(reportOption)
                .build();
    }
}