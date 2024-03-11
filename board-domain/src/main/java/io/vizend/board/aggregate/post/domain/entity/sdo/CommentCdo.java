package io.vizend.board.aggregate.post.domain.entity.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentCdo extends CreationDataObject {
    //
    private String text;
    private String displayName;
    private boolean accepted;
    private String postId;

    public static CommentCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, CommentCdo.class);
    }

    public static CommentCdo sample() {
        //
        return CommentCdo
                .builder()
                .text("This is my sample comment.")
                .displayName(StageContext.get().getDisplayName())
                .postId(PostCdo.sample().genId())
                .accepted(true)
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return Comment.genId();
    }

    public String toString() {
        //
        return toJson();
    }
}
