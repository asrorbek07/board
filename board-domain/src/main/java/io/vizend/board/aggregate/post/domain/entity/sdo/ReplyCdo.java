package io.vizend.board.aggregate.post.domain.entity.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyCdo extends CreationDataObject {
    //
    private String text;
    private String displayName;
    private String commentId;

    public static ReplyCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, ReplyCdo.class);
    }

    public static ReplyCdo sample() {
        //
        return ReplyCdo.builder()
                .text("This is my sample reply to the comment.")
                .displayName(StageContext.get().getDisplayName())
                .commentId(CommentCdo.sample().genId())
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return Reply.genId();
    }

    public String toString() {
        //
        return toJson();
    }
}
