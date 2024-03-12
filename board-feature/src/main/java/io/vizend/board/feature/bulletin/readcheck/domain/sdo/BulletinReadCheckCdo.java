package io.vizend.board.feature.bulletin.readcheck.domain.sdo;

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
public class BulletinReadCheckCdo extends CreationDataObject {
    //
    private String postId;

    public static BulletinReadCheckCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BulletinReadCheckCdo.class);
    }

    public static BulletinReadCheckCdo sample() {
        //
        ReadCheckCdo sample = ReadCheckCdo.sample();
        return BulletinReadCheckCdo
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
