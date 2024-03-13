package io.vizend.board.feature.bulletin.reply.domain.sdo;

import io.vizend.accent.util.json.JsonSerializable;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BulletinReplyRdo implements JsonSerializable {
    private Reply reply;
    private List<ThumbUpRecord> thumbUps;
}
