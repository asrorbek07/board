/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.qna.board.query;

import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole
public class FindQnaBoardsQuery extends QueryRequest<List<Board>> {
    //

    public void validate() {
        /**
         *  FIXME : User Implementation
         * Example.
         * Assert.hasText(skuNo, "'skuNo' is required");
         * Assert.isTrue(increaseRate > 0, "'increaseRate' is greater than 0");
         */
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindQnaBoardsQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindQnaBoardsQuery.class);
    }

    public static FindQnaBoardsQuery sample() {
        //
        return new FindQnaBoardsQuery();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
