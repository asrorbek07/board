/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.entity.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.domain.type.IdName;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThumbUpRecordCdo extends CreationDataObject {
    //
    private IdName actor;
    private SentenceType sentenceType;
    private String sentenceId;

    public static ThumbUpRecordCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, ThumbUpRecordCdo.class);
    }

    public static ThumbUpRecordCdo sample() {
        //
        StageContext.setDefault();
        String actorId = StageContext.get().getActorId();
        String actorName = StageContext.get().getDisplayName();
        IdName actor = IdName.of(actorId, actorName);
        return ThumbUpRecordCdo
                .builder()
                .actor(actor)
                .sentenceType(SentenceType.Post)
                .sentenceId(PostCdo.sample().genId())
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return ThumbUpRecord.genId();
    }

    @Override
    public String toString() {
        //
        return toJson();
    }
}
