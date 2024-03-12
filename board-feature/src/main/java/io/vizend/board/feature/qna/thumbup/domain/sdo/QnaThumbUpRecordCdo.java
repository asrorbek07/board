/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.feature.qna.thumbup.domain.sdo;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.domain.type.IdName;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.sdo.ThumbUpRecordCdo;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnaThumbUpRecordCdo extends CreationDataObject {
    //
    private SentenceType sentenceType;
    private String sentenceId;

    public static QnaThumbUpRecordCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, QnaThumbUpRecordCdo.class);
    }

    public static QnaThumbUpRecordCdo sample() {
        //

        ThumbUpRecordCdo sample = ThumbUpRecordCdo.sample();
        return QnaThumbUpRecordCdo
                .builder()
                .sentenceType(sample.getSentenceType())
                .sentenceId(sample.getSentenceId())
                .build();
    }

    public ThumbUpRecordCdo genThumbUpRecordCdo(){
        //
        return ThumbUpRecordCdo.builder()
                .reader(IdName.of(StageContext.get().getActorId(), StageContext.get().getDisplayName()))
                .sentenceType(sentenceType)
                .sentenceId(sentenceId)
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return ThumbUpRecordCdo.sample().genId();
    }

    @Override
    public String toString() {
        //
        return toJson();
    }
}
