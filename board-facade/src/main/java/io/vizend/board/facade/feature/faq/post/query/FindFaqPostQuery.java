/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.post.query;

import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.feature.faq.post.domain.sdo.FaqPostCdo;
import io.vizend.board.feature.faq.post.domain.sdo.FaqPostRdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.board.facade.BoardRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindFaqPostQuery extends QueryRequest<FaqPostRdo> {
    //
    private String postId;

    public void validate() {
        //
        Assert.notNull(postId, "postId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindFaqPostQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindFaqPostQuery.class);
    }

    public static FindFaqPostQuery sample() {
        //
        return new FindFaqPostQuery(FaqPostCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
