/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.board.command;

import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.feature.qna.board.domain.sdo.QnaBoardCdo;
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
public class RegisterQnaBoardCommand extends CommandRequest {
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

    public static RegisterQnaBoardCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, RegisterQnaBoardCommand.class);
    }

    public QnaBoardCdo genQanBoardCdo(){
        //
        return QnaBoardCdo.builder()
                .title(title)
                .description(description).build();
    }

    public static RegisterQnaBoardCommand sample() {
        //
        QnaBoardCdo sample = QnaBoardCdo.sample();
        return new RegisterQnaBoardCommand(
                sample.getTitle(),
                sample.getDescription()
        );
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
