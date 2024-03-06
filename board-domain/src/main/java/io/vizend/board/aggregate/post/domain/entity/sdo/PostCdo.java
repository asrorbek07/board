package io.vizend.board.aggregate.post.domain.entity.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.aggregate.post.domain.entity.vo.ReportOption;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCdo extends CreationDataObject {
    //
    private long sequence;
    private String title;
    private String displayName;
    private String content;
    private String boardId;
    private CommentRule commentRule;
    private ReportOption reportOption;

    public static PostCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, PostCdo.class);
    }

    public static PostCdo sample() {
        //
        return PostCdo
                .builder()
                .sequence(1L)
                .title("My Sample Post Title")
                .displayName(StageContext.get().getDisplayName())
                .content("This is my content for the post")
                .boardId(BoardCdo.sample().genId())
                .commentRule(CommentRule.sample())
                .reportOption(ReportOption.sample())
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return Post.genId(boardId, sequence);
    }

    public String toString() {
        //
        return toJson();
    }
}
