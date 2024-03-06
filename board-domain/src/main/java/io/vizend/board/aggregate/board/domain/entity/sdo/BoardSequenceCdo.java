package io.vizend.board.aggregate.board.domain.entity.sdo;

import io.vizend.accent.domain.entity.CreationDataObject;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardSequenceCdo extends CreationDataObject {
    //
    private String entityName;

    public static BoardSequenceCdo fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BoardSequenceCdo.class);
    }

    public static BoardSequenceCdo sample() {
        //
        return BoardSequenceCdo
                .builder()
                .entityName(BoardSequence.class.getSimpleName())
                .build();
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    @Override
    public String genId() {
        //
        return BoardSequence.genId();
    }

    @Override
    public String toString() {
        //
        return toJson();
    }
}
