/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.board.command;

import io.vizend.board.feature.bulletin.board.domain.sdo.BulletinBoardCdo;
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
public class RemoveBulletinBoardCommand extends CommandRequest {
    //
    private String boardId;

    public void validate() {
        //
        Assert.notNull(boardId,"boardId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RemoveBulletinBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RemoveBulletinBoardCommand.class);
    }

    public static RemoveBulletinBoardCommand sample() {
        //
        return new RemoveBulletinBoardCommand(BulletinBoardCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
