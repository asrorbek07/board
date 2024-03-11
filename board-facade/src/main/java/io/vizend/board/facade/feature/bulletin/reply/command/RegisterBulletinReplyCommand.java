/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.reply.command;

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
@AuthorizedRole
public class RegisterBulletinReplyCommand extends CommandRequest {
    //
    private String text;
    private String commentId;

    public void validate() {
        //
        Assert.notNull(text,"text is required");
        Assert.notNull(commentId,"commentId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterBulletinReplyCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterBulletinReplyCommand.class);
    }

    public static RegisterBulletinReplyCommand sample() {
        //
        BulletinReplyCdo sample = BulletinReplyCdo.sample();
        return new RegisterBulletinReplyCommand(
                sample().text,
                sample().commentId
        );
    }

    public BulletinReplyCdo genBulletinReplyCdo(){
        return BulletinReplyCdo.builder()
                .text(text)
                .commentId(commentId)
                .build();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
