package io.vizend.board.aggregate.board.domain.entity.sdo;

import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardCdo extends CreationDataObject {
    //
    private String title;
    private String description;
    private BoardType boardType;
    private BoardPolicy boardPolicy;
    private long sequence;

    public static BoardCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BoardCdo.class);
    }

    public static BoardCdo sample() {
        //
        return BoardCdo
                .builder()
                .title("My Sample Board")
                .description("Some lorem description for the board")
                .boardType(BoardType.BulletinBoard)
                .boardPolicy(BoardPolicy.sample())
                .sequence(1L)
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    public String genId(String stageId) {
        //
        return Board.genId(stageId, sequence);
    }

    public String toString() {
        //
        return toJson();
    }
}
