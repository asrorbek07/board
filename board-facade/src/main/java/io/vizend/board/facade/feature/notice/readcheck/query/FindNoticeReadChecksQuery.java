/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.readcheck.query;

import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.feature.notice.readcheck.domain.sdo.NoticeReadCheckCdo;
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
public class FindNoticeReadChecksQuery extends QueryRequest<List<ReadCheck>> {
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

    public static FindNoticeReadChecksQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindNoticeReadChecksQuery.class);
    }

    public static FindNoticeReadChecksQuery sample() {
        //
        return new FindNoticeReadChecksQuery(NoticeReadCheckCdo.sample().getPostId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
