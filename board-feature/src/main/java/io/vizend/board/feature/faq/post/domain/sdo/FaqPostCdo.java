package io.vizend.board.feature.faq.post.domain.sdo;

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
public class FaqPostCdo extends CreationDataObject {
    //
    private String title;
    private String content;
    private String boardId;

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
                .content(postCdoSample.getContent())
                .boardId(postCdoSample.getBoardId())
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
                .build();
    }
}
