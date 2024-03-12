/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.thumbup.query;

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.board.feature.notice.thumbup.domain.sdo.NoticeThumbUpRecordCdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AuthorizedRole
public class FindNoticeThumbUpsQuery extends QueryRequest<List<ThumbUpRecord>> {
    //
    private String sentenceId;

    public void validate() {
        //
        Assert.notNull(sentenceId,"sentenceId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindNoticeThumbUpsQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindNoticeThumbUpsQuery.class);
    }

    public static FindNoticeThumbUpsQuery sample() {
        //
        return new FindNoticeThumbUpsQuery(NoticeThumbUpRecordCdo.sample().getSentenceId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
