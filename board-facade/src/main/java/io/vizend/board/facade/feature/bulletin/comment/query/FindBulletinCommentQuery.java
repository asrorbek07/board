/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.comment.query;

import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentCdo;
import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentRdo;
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
public class FindBulletinCommentQuery extends QueryRequest<BulletinCommentRdo> {
    //
    private String commentId;

    public void validate() {
        //
        Assert.notNull(commentId,"commentId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindBulletinCommentQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindBulletinCommentQuery.class);
    }

    public static FindBulletinCommentQuery sample() {
        //
        return new FindBulletinCommentQuery(BulletinCommentCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
