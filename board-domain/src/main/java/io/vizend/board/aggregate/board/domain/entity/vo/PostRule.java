package io.vizend.board.aggregate.board.domain.entity.vo;

import io.vizend.accent.domain.entity.ValueObject;
import io.vizend.accent.util.json.JsonUtil;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRule implements ValueObject {
    //
    private boolean anonymous;
    private boolean thumbUp;

    public static PostRule defaultRule() {
        //
        return PostRule
                .builder()
                .anonymous(false)
                .thumbUp(true)
                .build();
    }

    public static PostRule fromJson(String json) {
        //
        return JsonUtil.fromJson(json, PostRule.class);
    }

    public static PostRule sample() {
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
