/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.answer.command;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerCdo;
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
public class ModifyQnaAnswerCommand extends CommandRequest {
    //
    private String answerId;
    private NameValueList nameValueList;

    public void validate() {
        //
        Assert.notNull(answerId,"answerId is required");
        Assert.notNull(nameValueList,"nameValueList is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static ModifyQnaAnswerCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, ModifyQnaAnswerCommand.class);
    }

    public static ModifyQnaAnswerCommand sample() {
        //
        QnaAnswerCdo sample = QnaAnswerCdo.sample();
        return new ModifyQnaAnswerCommand(
                sample.genId(),
                NameValueList.sample()
        );
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
