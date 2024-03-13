/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.board.command;

import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.facade.feature.faq.board.command.RegisterFaqBoardCommand;
import io.vizend.board.feature.bulletin.board.domain.sdo.BulletinBoardCdo;
import io.vizend.board.feature.faq.board.domain.sdo.FaqBoardCdo;
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
public class RegisterBulletinBoardCommand extends CommandRequest {
    //
    private String title;
    private String description;

    public void validate() {
        //
        Assert.notNull(title, "title' is required");
        Assert.notNull(description, "'description' is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterBulletinBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterBulletinBoardCommand.class);
    }

    public BulletinBoardCdo genBulletinBoardCdo(){
        //
        return BulletinBoardCdo.builder()
                .title(title)
                .description(description)
                .build();
    }

    public static RegisterBulletinBoardCommand sample() {
        //
        BulletinBoardCdo sample = BulletinBoardCdo.sample();
        return new RegisterBulletinBoardCommand(
                sample.getTitle(),
                sample.getDescription()
        );
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
