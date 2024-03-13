package io.vizend.board.feature.bulletin.board.domain.sdo;

import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.aggregate.board.domain.entity.vo.PostRule;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulletinBoardCdo extends CreationDataObject {
    //
    private String title;
    private String description;

    public static BulletinBoardCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BulletinBoardCdo.class);
    }

    public static BulletinBoardCdo sample() {
        //

        BoardCdo boardCdo = BoardCdo.sample();
        return BulletinBoardCdo
                .builder()
                .title(boardCdo.getTitle())
                .description(boardCdo.getDescription())
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    public BoardCdo genBoardCdo() {
        //
        return BoardCdo.builder()
                .title(this.title)
                .description(this.description)
                .boardType(BoardType.BulletinBoard)
                .boardPolicy(BoardPolicy.defaultPolicy())
                .build();
    }

    @Override
    public String genId() {
        //
        return BoardCdo.sample().genId();
    }

    public String toString() {
        //
        return toJson();
    }
}
