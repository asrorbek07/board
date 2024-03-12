/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.readcheck.command;

import io.vizend.board.feature.bulletin.readcheck.domain.sdo.BulletinReadCheckCdo;
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
public class RegisterBulletinReadCheckCommand extends CommandRequest {
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

    public static RegisterBulletinReadCheckCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterBulletinReadCheckCommand.class);
    }

    public static RegisterBulletinReadCheckCommand sample() {
        //
        BulletinReadCheckCdo sample = BulletinReadCheckCdo.sample();
        return new RegisterBulletinReadCheckCommand(sample.getPostId());
    }

    public BulletinReadCheckCdo genBulletinReadCheckCdo(){
        //
        return BulletinReadCheckCdo.builder()
                .postId(postId)
                .build();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
