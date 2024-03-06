/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.faq.command;

import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.board.facade.BoardRole;
import io.vizend.accent.domain.message.CommandRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AuthorizedRole(BoardRole.Director)
public class RegisterFaqBoardCommand extends CommandRequest {
    //
    private BoardCdo boardCdo;

    public void validate() {
        //
        Assert.notNull(boardCdo, "'boardCdo' is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterFaqBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterFaqBoardCommand.class);
    }

    public static RegisterFaqBoardCommand sample() {
        //
        return new RegisterFaqBoardCommand(BoardCdo.sample());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
