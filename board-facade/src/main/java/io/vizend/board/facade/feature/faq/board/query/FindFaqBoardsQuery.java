/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.faq.board.query;

import io.vizend.board.aggregate.board.domain.entity.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole
public class FindFaqBoardsQuery extends QueryRequest<List<Board>> {
    //

    public void validate() {
        //
    }


    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindFaqBoardsQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindFaqBoardsQuery.class);
    }

    public static FindFaqBoardsQuery sample() {
        //
        return new FindFaqBoardsQuery();
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
