package io.vizend.board.feature.qna.reply.domain.sdo;

import io.vizend.accent.util.json.JsonSerializable;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.domain.entity.Reply;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class QnaReplyRdo implements JsonSerializable {
    private Reply reply;
    private List<ThumbUpRecord> thumbUps;
}
