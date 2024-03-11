/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.question.command;

import io.vizend.accent.domain.type.NameValueList;
import io.vizend.board.feature.qna.question.domain.sdo.QnaQuestionCdo;
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
public class ModifyQnaQuestionCommand extends CommandRequest {
    //
    private String questionId;
    private NameValueList nameValueList;

    public void validate() {
        //
        Assert.notNull(questionId, "postId is required");
        Assert.notNull(nameValueList,"nameValueList is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static ModifyQnaQuestionCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, ModifyQnaQuestionCommand.class);
    }

    public static ModifyQnaQuestionCommand sample() {
        //
        return new ModifyQnaQuestionCommand(QnaQuestionCdo.sample().genId(),NameValueList.sample());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
