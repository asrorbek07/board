/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.reply.query;

import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.feature.bulletin.reply.domain.sdo.BulletinReplyRdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.board.facade.BoardRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @AuthorizedRole
public class FindBulletinRepliesQuery extends QueryRequest<List<BulletinReplyRdo>> {
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

    public static FindBulletinRepliesQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindBulletinRepliesQuery.class);
    }

    public static FindBulletinRepliesQuery sample() {
        //
        return new FindBulletinRepliesQuery();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
