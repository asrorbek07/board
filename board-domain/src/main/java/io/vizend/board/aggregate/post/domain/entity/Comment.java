package io.vizend.board.aggregate.post.domain.entity;

import io.vizend.accent.domain.annotation.FieldSourceId;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.accent.domain.type.NameValue;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.post.domain.entity.sdo.CommentCdo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Comment extends StageEntity {
    //
    private String text;
    private String displayName;
    private boolean accepted;
    @FieldSourceId
    private String postId;

    public Comment(String id, ActorKey actorKey) {
        //
        super(id, actorKey);
    }

    public Comment(CommentCdo commentCdo) {
        //
        super(commentCdo.genId(), commentCdo.getRequesterKey());
        BeanUtils.copyProperties(commentCdo, this);
        this.accepted = false;
    }

    public static String genId() {
        //
        return UUID.randomUUID().toString();
    }

    public static Comment fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Comment.class);
    }

    public static Comment sample() {
        //
        return new Comment(
                CommentCdo.sample()
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
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "text":
                    this.text = value;
                    break;
                case "displayName":
                    this.displayName = value;
                    break;
                case "accepted":
                    this.accepted = Boolean.parseBoolean(value);
                    break;
                default:
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }
}
