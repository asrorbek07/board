package io.vizend.board.aggregate.board.domain.entity.vo;

import io.vizend.accent.domain.entity.ValueObject;
import io.vizend.accent.util.json.JsonUtil;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRule implements ValueObject {
    //
    private boolean allowed;
    private boolean anonymous;
    private boolean thumbUp;

    public static CommentRule defaultRule() {
        //
        return CommentRule
                .builder()
                .allowed(true)
                .anonymous(false)
                .thumbUp(true)
                .build();
    }

    public static CommentRule fromJson(String json) {
        //
        return JsonUtil.fromJson(json, CommentRule.class);
    }

    public static CommentRule sample() {
        //
        return defaultRule();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    public String toString() {
        //
        return toJson();
    }
}
