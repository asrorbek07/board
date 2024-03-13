/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.question.query;

import io.vizend.board.feature.qna.question.domain.sdo.QnaQuestionCdo;
import io.vizend.board.feature.qna.question.domain.sdo.QnaQuestionRdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AuthorizedRole
public class FindQnaQuestionQuery extends QueryRequest<QnaQuestionRdo> {
    //
    private String questionId;

    public void validate() {
        //
        Assert.notNull(questionId,"questionId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindQnaQuestionQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindQnaQuestionQuery.class);
    }

    public static FindQnaQuestionQuery sample() {
        //
        return new FindQnaQuestionQuery(QnaQuestionCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
