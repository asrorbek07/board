package io.vizend.board.feature.qna.board.domain.sdo;

import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnaBoardCdo extends CreationDataObject {
    //
    private String title;
    private String description;
    private BoardPolicy boardPolicy;

    public static QnaBoardCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, QnaBoardCdo.class);
    }

    public static QnaBoardCdo sample() {
        //
        BoardCdo boardCdo = BoardCdo.sample();
        return QnaBoardCdo
                .builder()
                .title(boardCdo.getTitle())
                .description(boardCdo.getDescription())
                .boardPolicy(boardCdo.getBoardPolicy())
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
                .boardType(BoardType.QNABoard)
                .boardPolicy(this.boardPolicy)
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
