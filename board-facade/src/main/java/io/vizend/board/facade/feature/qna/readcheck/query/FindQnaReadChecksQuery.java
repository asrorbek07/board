/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.readcheck.query;

import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.feature.qna.readcheck.domain.sdo.QnaReadCheckCdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AuthorizedRole
public class FindQnaReadChecksQuery extends QueryRequest<List<ReadCheck>> {
    //
    private String postId;

    public void validate() {
        //
        Assert.notNull(postId,"postId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindQnaReadChecksQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindQnaReadChecksQuery.class);
    }

    public static FindQnaReadChecksQuery sample() {
        //
        return new FindQnaReadChecksQuery(QnaReadCheckCdo.sample().getPostId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
