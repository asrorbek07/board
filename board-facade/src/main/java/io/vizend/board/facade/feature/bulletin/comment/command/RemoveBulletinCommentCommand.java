/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.comment.command;

import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentCdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.accent.domain.message.CommandRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @AuthorizedRole
public class RemoveBulletinCommentCommand extends CommandRequest {
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

    public static RemoveBulletinCommentCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RemoveBulletinCommentCommand.class);
    }

    public static RemoveBulletinCommentCommand sample() {
        //
        return new RemoveBulletinCommentCommand(BulletinCommentCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
