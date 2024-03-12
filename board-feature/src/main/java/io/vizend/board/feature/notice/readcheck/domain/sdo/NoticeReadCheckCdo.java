package io.vizend.board.feature.notice.readcheck.domain.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.domain.type.IdName;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReadCheckCdo;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeReadCheckCdo extends CreationDataObject {
    //
    private String postId;

    public static NoticeReadCheckCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, NoticeReadCheckCdo.class);
    }

    public static NoticeReadCheckCdo sample() {
        //
        ReadCheckCdo sample = ReadCheckCdo.sample();
        return NoticeReadCheckCdo
                .builder()
                .postId(sample.getPostId())
                .build();
    }

    public ReadCheckCdo genReadCheckCdo(){
        return ReadCheckCdo.builder()
                .reader(IdName.of(StageContext.get().getActorId(), StageContext.get().getDisplayName()))
                .postId(postId)
                .build();

    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return ReadCheck.genId(postId, super.requesterKey.getId());
    }

    public String toString() {
        //
        return toJson();
    }
}
