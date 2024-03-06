package io.vizend.board.aggregate.board.domain.entity;

import io.vizend.accent.domain.annotation.FieldImmutable;
import io.vizend.accent.domain.entity.StageEntity;
import io.vizend.accent.domain.tenant.ActorKey;
import io.vizend.accent.domain.type.NameValue;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardSequenceCdo;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardSequence extends StageEntity {
    //
    @FieldImmutable
    private String entityName;
    private long sequence;

    public BoardSequence(String id, ActorKey actorKey) {
        //
        super(id, actorKey);
    }

    public BoardSequence(BoardSequenceCdo boardSequenceCdo) {
        //
        super(boardSequenceCdo.genId(), boardSequenceCdo.getRequesterKey());
        BeanUtils.copyProperties(boardSequenceCdo, this);
        this.sequence = 1L;
    }


    public static String genId() {
        //
        return UUID.randomUUID().toString();
    }

    public static BoardSequence fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BoardSequence.class);
    }

    public static BoardSequence sample() {
        //
        return new BoardSequence(
                BoardSequenceCdo.sample()
        );
    }

    public static void main(String[] args) {
        //
        System.out.println(sample().toPrettyJson());
    }

    public String toString() {
        //
        return toJson();
    }

    @Override
    protected void modifyAttributes(NameValueList nameValues) {
        //
        for (NameValue nameValue : nameValues.list()) {
            String value = nameValue.getValue();
            switch (nameValue.getName()) {
                case "sequence":
                    this.sequence = Long.parseLong(value);
                    break;
                default:
                    throw new IllegalArgumentException("Update not allowed: " + nameValue);
            }
        }
    }

}
