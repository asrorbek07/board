package io.vizend.board.feature.bulletin.comment.domain.sdo;

import io.vizend.accent.util.json.JsonSerializable;
import io.vizend.board.aggregate.post.domain.entity.Comment;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BulletinCommentRdo implements JsonSerializable {
    private Comment comment;
    private List<ThumbUpRecord> thumbUps;
}
