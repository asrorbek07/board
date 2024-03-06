package io.vizend.board.aggregate.post.domain.entity;

import io.vizend.accent.domain.annotation.FieldSourceId;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.accent.domain.type.NameValue;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReplyCdo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Reply extends StageEntity {
    //
    private String text;
    private String displayName;
    @FieldSourceId
    private String commentId;

    public Reply(String id, ActorKey requesterKey) {
        //
        super(id, requesterKey);
    }

    public Reply(ReplyCdo replyCdo) {
        //
        super(replyCdo.genId(), replyCdo.getRequesterKey());
        BeanUtils.copyProperties(replyCdo, this);
    }

    public static String genId() {
        //
        return UUID.randomUUID().toString();
    }

    public static Reply fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Reply.class);
    }

    public static Reply sample() {
        //
        return new Reply(
                ReplyCdo.sample()
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
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "text":
                    this.text = value;
                    break;
                case "displayName":
                    this.displayName = value;
                    break;
                default:
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }
}
