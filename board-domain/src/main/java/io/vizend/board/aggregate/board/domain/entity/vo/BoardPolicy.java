/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.domain.entity.vo;


import io.vizend.accent.domain.entity.ValueObject;
import io.vizend.accent.util.json.JsonUtil;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardPolicy implements ValueObject {
    //
    private PostRule postRule;
    private CommentRule commentRule;

    public static BoardPolicy defaultPolicy() {
        //
        return BoardPolicy
                .builder()
                .postRule(PostRule.defaultRule())
                .commentRule(CommentRule.defaultRule())
                .build();
    }


    public static BoardPolicy genFaqBoardPolicy(){
        //
        PostRule postRule = PostRule.builder()
                .anonymous(false)
                .thumbUp(false)
                .build();

        CommentRule commentRule = CommentRule.builder()
                .allowed(false)
                .anonymous(false)
                .thumbUp(false)
                .build();

        return BoardPolicy.builder()
                .postRule(postRule)
                .commentRule(commentRule)
                .build();
    }

    public static BoardPolicy genNoticeBoardPolicy(){
        //
        CommentRule commentRule = CommentRule.builder()
                .allowed(false)
                .anonymous(false)
                .thumbUp(false)
                .build();

        return BoardPolicy.builder()
                .postRule(PostRule.defaultRule())
                .commentRule(commentRule)
                .build();
    }

    public static BoardPolicy fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BoardPolicy.class);
    }

    public static BoardPolicy sample() {
        //
        return defaultPolicy();
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
}
