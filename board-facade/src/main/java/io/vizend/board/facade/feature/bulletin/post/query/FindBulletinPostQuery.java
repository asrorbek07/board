/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.post.query;

import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.feature.bulletin.post.domain.sdo.BulletinPostCdo;
import io.vizend.board.feature.bulletin.post.domain.sdo.BulletinPostRdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @AuthorizedRole
public class FindBulletinPostQuery extends QueryRequest<BulletinPostRdo> {
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

    public static FindBulletinPostQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindBulletinPostQuery.class);
    }

    public static FindBulletinPostQuery sample() {
        //
        return new FindBulletinPostQuery(BulletinPostCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
