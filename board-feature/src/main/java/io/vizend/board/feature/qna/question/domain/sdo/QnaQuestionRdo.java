package io.vizend.board.feature.qna.question.domain.sdo;

import io.vizend.accent.util.json.JsonSerializable;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class QnaQuestionRdo implements JsonSerializable {
    private Post post;
    private List<ThumbUpRecord> thumbUps;
    private List<ReadCheck> readChecks;
}
