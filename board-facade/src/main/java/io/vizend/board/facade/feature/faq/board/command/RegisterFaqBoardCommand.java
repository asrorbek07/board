/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.board.command;

import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.feature.faq.board.domain.sdo.FaqBoardCdo;
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
public class RegisterFaqBoardCommand extends CommandRequest {
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

    public static RegisterFaqBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterFaqBoardCommand.class);
    }

    public FaqBoardCdo genFaqBoardCdo(){
        //
        return FaqBoardCdo.builder()
                .title(title)
                .description(description)
                .build();
    }

    public static RegisterFaqBoardCommand sample() {
        //
        FaqBoardCdo sample = FaqBoardCdo.sample();
        return new RegisterFaqBoardCommand(
                sample.getTitle(),
                sample.getDescription()
        );
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
