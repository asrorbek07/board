package io.vizend.board.aggregate.post.domain.entity;

import io.vizend.accent.domain.annotation.FieldImmutable;
import io.vizend.accent.domain.annotation.FieldSourceId;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.accent.domain.type.IdName;
import io.vizend.accent.domain.type.NameValue;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReadCheckCdo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ReadCheck extends StageEntity {
    //
    @FieldImmutable
    private IdName actor;
    @FieldSourceId
    private String postId;

    public ReadCheck(String id, ActorKey actorKey) {
        //
        super(id, actorKey);
    }

    public ReadCheck(ReadCheckCdo readCheckCdo) {
        //
        super(readCheckCdo.genId(), readCheckCdo.getRequesterKey());
        BeanUtils.copyProperties(readCheckCdo, this);
    }

    public static String genId(String postId, String actorId) {
        //
        return String.format("%s-%s",
                postId,
                actorId
        );
    }

    public static ReadCheck fromJson(String json) {
        //
        return JsonUtil.fromJson(json, ReadCheck.class);
    }

    public static ReadCheck sample() {
        //
        return new ReadCheck(
                ReadCheckCdo.sample()
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

    @Override
    protected void modifyAttributes(NameValueList nameValues) {
        //
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                default:
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }
}
