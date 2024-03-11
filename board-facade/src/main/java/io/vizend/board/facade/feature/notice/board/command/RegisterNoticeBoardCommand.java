/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.board.command;

import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.facade.feature.bulletin.board.command.RegisterBulletinBoardCommand;
import io.vizend.board.feature.bulletin.board.domain.sdo.BulletinBoardCdo;
import io.vizend.board.feature.notice.board.domain.sdo.NoticeBoardCdo;
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
public class RegisterNoticeBoardCommand extends CommandRequest {
    //
    private String title;
    private String description;
    private BoardPolicy boardPolicy;

    public void validate() {
        //
        Assert.notNull(title, "title' is required");
        Assert.notNull(description, "'description' is required");
        Assert.notNull(boardPolicy, "'boardPolicy' is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterNoticeBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterNoticeBoardCommand.class);
    }

    public NoticeBoardCdo genNoticeBoardCdo(){
        //
        return NoticeBoardCdo.builder()
                .title(title)
                .description(description)
                .boardPolicy(boardPolicy)
                .build();
    }

    public static RegisterNoticeBoardCommand sample() {
        //
        NoticeBoardCdo sample = NoticeBoardCdo.sample();
        return new RegisterNoticeBoardCommand(
                sample.getTitle(),
                sample.getDescription(),
                sample.getBoardPolicy()
        );
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
