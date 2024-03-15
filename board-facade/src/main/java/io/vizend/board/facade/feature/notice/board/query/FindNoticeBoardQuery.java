/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.board.query;

import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.feature.notice.board.domain.sdo.NoticeBoardCdo;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.message.QueryRequest;
import io.vizend.accent.util.json.JsonUtil;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindNoticeBoardQuery extends QueryRequest<Board> {
    //
    private String boardId;

    public void validate() {
        //
        Assert.notNull(boardId,"postId is required");
    }

    @Override
    public String toString() {
        /*Gen by Vizend Studio v5.1.0*/
        return toPrettyJson();
    }

    public static FindNoticeBoardQuery fromJson(String json) {
        /*Gen by Vizend Studio v5.1.0*/
        return JsonUtil.fromJson(json, FindNoticeBoardQuery.class);
    }

    public static FindNoticeBoardQuery sample() {
        //
        return new FindNoticeBoardQuery(NoticeBoardCdo.sample().genId());
    }

    public static void main(String[] args) {
        /*Gen by Vizend Studio v5.1.0*/
        System.out.println(sample().toPrettyJson());
    }
}
