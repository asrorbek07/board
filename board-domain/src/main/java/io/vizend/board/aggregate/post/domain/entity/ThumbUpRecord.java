/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.entity;

import io.vizend.accent.domain.annotation.FieldImmutable;
import io.vizend.accent.domain.annotation.FieldSourceId;
import io.vizend.accent.domain.entity.DomainAggregate;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.accent.domain.type.IdName;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.sdo.ThumbUpRecordCdo;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ThumbUpRecord extends StageEntity implements DomainAggregate {
    //
    @FieldImmutable
    private IdName reader;
    @FieldImmutable
    private SentenceType sentenceType;
    @FieldSourceId
    private String sentenceId;                  // postId, commentId, replyId

    public ThumbUpRecord(String id, ActorKey requesterKey) {
        //
        super(id, requesterKey);
    }

    public ThumbUpRecord(ThumbUpRecordCdo thumbUpRecordCdo) {
        //
        super(thumbUpRecordCdo.genId(), thumbUpRecordCdo.getRequesterKey());
        BeanUtils.copyProperties(thumbUpRecordCdo, this);
    }

    public static String genId() {
        //
        return UUID.randomUUID().toString();
    }

    public static ThumbUpRecord fromJson(String json) {
        //
        return JsonUtil.fromJson(json, ThumbUpRecord.class);
    }

    public static ThumbUpRecord sample() {
        //
        return new ThumbUpRecord(
                ThumbUpRecordCdo.sample()
        );
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    @Override
    protected void modifyAttributes(NameValueList nameValues) {
        //
        throw new IllegalArgumentException("Update not allowed.");
    }
}
