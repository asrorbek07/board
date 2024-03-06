package io.vizend.board.aggregate.board.domain.entity;

import io.vizend.accent.domain.annotation.FieldImmutable;
import io.vizend.accent.domain.context.StageContext;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.accent.domain.type.NameValue;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends StageEntity {
    //
    private String title;
    private String description;
    @FieldImmutable
    private BoardType boardType;
    private BoardPolicy boardPolicy;
    private long postSequence;

    public Board(String id, ActorKey actorKey) {
        //
        super(id, actorKey);
    }

    public Board(BoardCdo boardCdo) {
        //
        super(boardCdo.genId(StageContext.get().getStageId()), boardCdo.getRequesterKey());
        BeanUtils.copyProperties(boardCdo, this);
        setStageId(StageContext.get().getStageId());
        this.postSequence = 1L;
    }

    public static String genId(String stageId, long sequence) {
        //
        return String.format("%s-%d",
                stageId,
                sequence
        );
    }

    public static Board fromJson(String json) {
        //
        return JsonUtil.fromJson(json, Board.class);
    }

    public static Board sample() {
        //
        return new Board(
                BoardCdo.sample()
        );
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    @Override
    protected void modifyAttributes(NameValueList nameValues) {
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch(nameValue.getName()) {
                case "title":
                    this.title = value;
                    break;
                case "description":
                    this.description = value;
                    break;
                case "boardPolicy":
                    this.boardPolicy = JsonUtil.fromJson(value, BoardPolicy.class);
                    break;
                case "postSequence":
                    this.postSequence = Long.parseLong(value);
                    break;
                default:
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }
}
