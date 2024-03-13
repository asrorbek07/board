package io.vizend.board.aggregate.post.domain.entity;

import io.vizend.accent.domain.annotation.FieldImmutable;
import io.vizend.accent.domain.annotation.FieldSourceId;
import io.vizend.accent.domain.entity.DomainAggregate;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.accent.domain.type.NameValue;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.aggregate.post.domain.entity.sdo.PostCdo;
import io.vizend.board.aggregate.post.domain.entity.vo.PostState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class Post extends StageEntity implements DomainAggregate {
    //
    @FieldImmutable
    private long sequence;
    private String title;
    private String displayName;
    private String content;
    private PostState postState;
    private CommentRule commentRule;
    @FieldSourceId
    private String boardId;

    public Post(String id, ActorKey actorKey) {
        //
        super(id, actorKey);
    }

    public Post(PostCdo postCdo) {
        //
        super(postCdo.genId(), postCdo.getRequesterKey());
        BeanUtils.copyProperties(postCdo, this);
        this.postState = PostState.OPEN;
    }

    public static String genId(String boardId, long sequence) {
        //
        return String.format("%s-%d",
                boardId,
                sequence
        );
    }

    public static Post fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Post.class);
    }

    public static Post sample() {
        //
        return new Post(
                PostCdo.sample()
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
                case "title":
                    this.title = value;
                    break;
                case "displayName":
                    this.displayName = value;
                    break;
                case "content":
                    this.content = value;
                    break;
                case "postState":
                    this.postState = PostState.valueOf(value);
                    break;
                case "commentRule":
                    this.commentRule = JsonUtil.fromJson(value, CommentRule.class);
                    break;
                default:
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }
}
