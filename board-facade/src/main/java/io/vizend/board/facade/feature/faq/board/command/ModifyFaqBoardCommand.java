/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.board.command;

import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
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
public class ModifyFaqBoardCommand extends CommandRequest {
    //
    private String boardId;
    private NameValueList nameValueList;

    public void validate() {
        //
        Assert.notNull(boardId, "boardId is required");
        Assert.notNull(nameValueList, "nameValueList is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static ModifyFaqBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, ModifyFaqBoardCommand.class);
    }

    public static ModifyFaqBoardCommand sample() {
        //
        return new ModifyFaqBoardCommand(
                FaqBoardCdo.sample().genId(),
                NameValueList.sample()
        );
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
