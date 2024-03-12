package io.vizend.board.feature.bulletin.reply.domain.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReplyCdo;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BulletinReplyCdo extends CreationDataObject {
    //
    private String text;
    private String commentId;

    public static BulletinReplyCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BulletinReplyCdo.class);
    }

    public static BulletinReplyCdo sample() {
        //
        ReplyCdo sample = ReplyCdo.sample();
        return new BulletinReplyCdo(
                sample.getText(),
                sample.getCommentId()
        );
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    public String toString() {
        //
        return toJson();
    }

    public ReplyCdo genReplyCdo() {
        //
        return ReplyCdo
                .builder()
                .text(this.text)
                .displayName(StageContext.get().getDisplayName())
                .commentId(this.commentId)
                .build();
    }

    @Override
    public String genId() {
        return ReplyCdo.sample().genId();
    }
}
