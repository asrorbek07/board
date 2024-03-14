/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.answer.command;

import io.vizend.accent.domain.annotation.FieldSourceId;
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
// @AuthorizedRole
public class RegisterQnaAnswerCommand extends CommandRequest {
    //
    private String text;
    private String questionId;
    public void validate() {
        //
        Assert.notNull(text, "text is required");
        Assert.notNull(questionId,"questionId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterQnaAnswerCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterQnaAnswerCommand.class);
    }

    public static RegisterQnaAnswerCommand sample() {
        //
        QnaAnswerCdo sample = QnaAnswerCdo.sample();
        return new RegisterQnaAnswerCommand(
                sample.getText(),
                sample.getQuestionId()
        );
    }

    public QnaAnswerCdo genQnaAnswerCdo(){
        //
        return QnaAnswerCdo.builder()
                .text(text)
                .questionId(questionId)
                .build();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
