/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.board.command;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.feature.qna.board.domain.sdo.QnaBoardCdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.message.CommandRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModifyQnaBoardCommand extends CommandRequest {
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

    public static ModifyQnaBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, ModifyQnaBoardCommand.class);
    }

    public static ModifyQnaBoardCommand sample() {
        //
        return new ModifyQnaBoardCommand(QnaBoardCdo.sample().genId(),NameValueList.sample());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
