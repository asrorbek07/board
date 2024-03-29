/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.answer.query;

import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerRdo;
import io.vizend.board.feature.qna.answer.domain.sdo.QnaAnswerCdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindQnaAnswersQuery extends QueryRequest<List<QnaAnswerRdo>> {
    //
    private String questionId;

    public void validate() {
        Assert.notNull(questionId, "questionId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindQnaAnswersQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindQnaAnswersQuery.class);
    }

    public static FindQnaAnswersQuery sample() {
        //
        return new FindQnaAnswersQuery(QnaAnswerCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
