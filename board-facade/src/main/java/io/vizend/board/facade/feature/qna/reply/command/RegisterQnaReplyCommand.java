/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.reply.command;

import io.vizend.board.feature.qna.reply.domain.sdo.QnaReplyCdo;
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
public class RegisterQnaReplyCommand extends CommandRequest {
    //
    private String text;
    private String commentId;

    public void validate() {
        //
        Assert.notNull(text,"text is required");
        Assert.notNull(commentId,"commentId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterQnaReplyCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterQnaReplyCommand.class);
    }

    public static RegisterQnaReplyCommand sample() {
        //
        QnaReplyCdo sample = QnaReplyCdo.sample();
        return new RegisterQnaReplyCommand(
                sample.getText(),
                sample.getCommentId()
        );
    }

    public QnaReplyCdo genQnaReplyCdo(){
        return QnaReplyCdo.builder()
                .text(text)
                .commentId(commentId)
                .build();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
