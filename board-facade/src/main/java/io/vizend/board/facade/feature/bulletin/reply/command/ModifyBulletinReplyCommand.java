/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.reply.command;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.feature.bulletin.reply.domain.sdo.BulletinReplyCdo;
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
public class ModifyBulletinReplyCommand extends CommandRequest {
    //
    private String replyId;
    private NameValueList nameValueList;

    public void validate() {
        //
        Assert.notNull(replyId,"replyId is required");
        Assert.notNull(nameValueList,"nameValueList is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static ModifyBulletinReplyCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, ModifyBulletinReplyCommand.class);
    }

    public static ModifyBulletinReplyCommand sample() {
        //
        return new ModifyBulletinReplyCommand(BulletinReplyCdo.sample().genId(),NameValueList.sample());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
