package io.vizend.board.feature.bulletin.post.domain.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulletinPostCdo extends CreationDataObject {
    //
    private String title;
    private String content;
    private String boardId;
    private CommentRule commentRule;

    public static BulletinPostCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BulletinPostCdo.class);
    }

    public static BulletinPostCdo sample() {
        //
        PostCdo postCdoSample = PostCdo.sample();
        return BulletinPostCdo
                .builder()
                .title(postCdoSample.getTitle())
                .content(postCdoSample.getContent())
                .boardId(postCdoSample.getBoardId())
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

    @Override
    public String genId() {
        //
        return PostCdo.sample().genId();
    }

    public PostCdo genPostCdo(){
        //
        return PostCdo
                .builder()
                .title(title)
                .displayName(StageContext.get().getDisplayName())
                .content(content)
                .boardId(boardId)
                .commentRule(commentRule)
                .build();
    }
}
