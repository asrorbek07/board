package io.vizend.board.aggregate.post.domain.entity.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.domain.type.IdName;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadCheckCdo extends CreationDataObject {
    //
    private IdName reader;
    private String postId;

    public ReadCheckCdo(String postId) {
        //
        String readerId = StageContext.get().getActorId();
        String readerName = StageContext.get().getDisplayName();
        IdName reader = IdName.of(readerId, readerName);
        this.reader = reader;
        this.postId = postId;
    }

    public static ReadCheckCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, ReadCheckCdo.class);
    }

    public static ReadCheckCdo sample() {
        //
        StageContext.setDefault();
        String actorId = StageContext.get().getActorId();
        String actorName = StageContext.get().getDisplayName();
        StageContext.get().getActorId();
        IdName actor = IdName.of(actorId, actorName);
        return ReadCheckCdo
                .builder()
                .reader(actor)
                .postId(PostCdo.sample().genId())
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
