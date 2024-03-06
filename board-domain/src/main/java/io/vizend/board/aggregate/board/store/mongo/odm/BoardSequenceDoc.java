/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo.odm;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import io.vizend.accent.store.mongo.StageEntityDoc;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "BOARD_SEQUENCE")
public class BoardSequenceDoc extends StageEntityDoc {
    /* Gen by Vizend Studio v5.1.0 */
    private String entityName; // 
    private long sequence;

    public BoardSequenceDoc(BoardSequence boardSequence) {
        /* Gen by Vizend Studio v5.1.0 */
        super(boardSequence);
        BeanUtils.copyProperties(boardSequence, this);
    }

    public BoardSequence toDomain() {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequence boardSequence = new BoardSequence(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, boardSequence);
        return boardSequence;
    }

    public static List<BoardSequence> toDomains(List<BoardSequenceDoc> boardSequenceDocs) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardSequenceDocs.stream().map(BoardSequenceDoc::toDomain).collect(Collectors.toList());
    }

    public static Page<BoardSequence> toDomains(Page<BoardSequenceDoc> boardSequenceDocsPage) {
        /* Gen by Vizend Studio v5.1.0 */
        List<BoardSequenceDoc> boardSequenceDocs = boardSequenceDocsPage.getContent();
        List<BoardSequence> boardSequences = toDomains(boardSequenceDocs);
        return new PageImpl<>(boardSequences, boardSequenceDocsPage.getPageable(), boardSequenceDocsPage.getTotalElements());
    }

    public static Slice<BoardSequence> toDomains(Slice<BoardSequenceDoc> boardSequenceDocsSlice) {
        /* Gen by Vizend Studio v5.1.0 */
        List<BoardSequenceDoc> boardSequenceDocs = boardSequenceDocsSlice.getContent();
        List<BoardSequence> boardSequences = toDomains(boardSequenceDocs);
        return new SliceImpl<>(boardSequences, boardSequenceDocsSlice.getPageable(), boardSequenceDocsSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static BoardSequenceDoc sample() {
        /* Gen by Vizend Studio v5.1.0 */
        return new BoardSequenceDoc(BoardSequence.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sample());
    }
}
