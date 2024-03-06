/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.faq.query;

import io.vizend.board.aggregate.board.domain.entity.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.board.facade.BoardRole;
import io.vizend.accent.domain.message.OffsetQueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.data.domain.Page;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AuthorizedRole(BoardRole.Director)
public class FindFAQBoardsByOffsetQuery extends OffsetQueryRequest<Page<Board>> {
    //
    private String stageId;

    public void validate() {
        //
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindFAQBoardsByOffsetQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindFAQBoardsByOffsetQuery.class);
    }

    public static FindFAQBoardsByOffsetQuery sample() {
        /* FIXME : User Implementation */
        return new FindFAQBoardsByOffsetQuery();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}