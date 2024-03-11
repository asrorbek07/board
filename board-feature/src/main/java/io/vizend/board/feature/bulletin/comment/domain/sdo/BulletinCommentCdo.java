package io.vizend.board.feature.bulletin.comment.domain.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.sdo.CommentCdo;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulletinCommentCdo extends CreationDataObject {
    //
    private String text;
    private String postId;

    public static BulletinCommentCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BulletinCommentCdo.class);
    }

    public static BulletinCommentCdo sample() {
        //
        CommentCdo sample = CommentCdo.sample();
        return BulletinCommentCdo
                .builder()
                .text(sample.getText())
                .postId(sample.getPostId())
                .build();
    }

    public CommentCdo genCommentCdo(){
        //
        return CommentCdo.builder()
                .text(text)
                .displayName(StageContext.get().getDisplayName())
                .postId(postId)
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
