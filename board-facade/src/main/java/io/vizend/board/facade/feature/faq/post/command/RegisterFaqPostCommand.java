/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.post.command;

import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.feature.faq.post.domain.sdo.FaqPostCdo;
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
public class RegisterFaqPostCommand extends CommandRequest {
    //
    private String title;
    private String content;
    private String boardId;
    public void validate() {
        //
        Assert.notNull(title,"title is required");
        Assert.notNull(content,"content is required");
        Assert.notNull(boardId,"boardId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static RegisterFaqPostCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterFaqPostCommand.class);
    }

    public static RegisterFaqPostCommand sample() {
        //
        FaqPostCdo sample = FaqPostCdo.sample();
        return new RegisterFaqPostCommand(
                sample.getTitle(),
                sample.getContent(),
                sample.getBoardId()
        );
    }

    public FaqPostCdo genFaqPostCdo(){
        //
        return FaqPostCdo.builder()
                .title(title)
                .content(content)
                .boardId(boardId)
                .build();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
