package io.vizend.board.feature.faq.post.domain.sdo;

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
public class FaqPostRdo implements JsonSerializable {
    private Post post;
}
