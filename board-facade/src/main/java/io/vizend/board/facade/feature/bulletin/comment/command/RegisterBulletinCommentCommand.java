/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.bulletin.comment.command;

import io.vizend.board.feature.bulletin.comment.domain.sdo.BulletinCommentCdo;
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
public class RegisterBulletinCommentCommand extends CommandRequest {
    //
    private String text;
    private String postId;

    public void validate() {
        //
        Assert.notNull(text, "text is required");
        Assert.notNull(postId,"postId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterBulletinCommentCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterBulletinCommentCommand.class);
    }

    public static RegisterBulletinCommentCommand sample() {
        //
        BulletinCommentCdo sample = BulletinCommentCdo.sample();
        return new RegisterBulletinCommentCommand(
                sample.getText(),
                sample.getPostId()
        );
    }

    public BulletinCommentCdo genBulletinCommentCdo(){
        //
        return BulletinCommentCdo.builder()
                .text(text)
                .postId(postId)
                .build();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
