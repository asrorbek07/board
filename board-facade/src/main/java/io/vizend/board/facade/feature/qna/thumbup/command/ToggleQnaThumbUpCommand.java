/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.thumbup.command;

import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;
import io.vizend.board.feature.qna.thumbup.domain.sdo.QnaThumbUpRecordCdo;
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
public class ToggleQnaThumbUpCommand extends CommandRequest {
    //
    private String sentenceType;
    private String sentenceId;

    public void validate() {
        //
        Assert.notNull(sentenceType,"sentenceType is required");
        Assert.notNull(sentenceId,"sentenceId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static ToggleQnaThumbUpCommand fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, ToggleQnaThumbUpCommand.class);
    }

    public static ToggleQnaThumbUpCommand sample() {
        //
        QnaThumbUpRecordCdo sample = QnaThumbUpRecordCdo.sample();
        return new ToggleQnaThumbUpCommand(
                sample.getSentenceType().toString(),
                sample.getSentenceId()
        );
    }

    public QnaThumbUpRecordCdo genQnaThumbUpRecordCdo(){
        //
        return QnaThumbUpRecordCdo.builder()
                .sentenceType(SentenceType.valueOf(sentenceType))
                .sentenceId(sentenceId)
                .build();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
