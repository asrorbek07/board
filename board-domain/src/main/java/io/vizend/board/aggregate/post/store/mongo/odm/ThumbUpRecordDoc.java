/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store.mongo.odm;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import io.vizend.accent.store.mongo.StageEntityDoc;
import io.vizend.board.aggregate.post.domain.entity.vo.SentenceType;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import org.springframework.beans.BeanUtils;
import io.vizend.accent.domain.type.IdName;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "THUMB_UP_RECORD")
public class ThumbUpRecordDoc extends StageEntityDoc {
    /* Gen by Vizend Studio v5.1.0 */
    private String readerId;
    private String readerName;
    private SentenceType sentenceType;
    private String sentenceId; // postId, commentId, replyId

    public ThumbUpRecordDoc(ThumbUpRecord thumbUpRecord) {
        /* Gen by Vizend Studio v5.1.0 */
        super(thumbUpRecord);
        BeanUtils.copyProperties(thumbUpRecord, this);
        if (thumbUpRecord.getReader() != null) {
            this.readerId = thumbUpRecord.getReader().getId();
            this.readerName = thumbUpRecord.getReader().getName();
        }
    }

    public ThumbUpRecord toDomain() {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecord thumbUpRecord = new ThumbUpRecord(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, thumbUpRecord);
        IdName reader = new IdName();
        reader.setId(readerId);
        reader.setName(readerName);
        thumbUpRecord.setReader(reader);
        return thumbUpRecord;
    }

    public static List<ThumbUpRecord> toDomains(List<ThumbUpRecordDoc> thumbUpRecordDocs) {
        /* Gen by Vizend Studio v5.1.0 */
        return thumbUpRecordDocs.stream().map(ThumbUpRecordDoc::toDomain).collect(Collectors.toList());
    }

    public static Page<ThumbUpRecord> toDomains(Page<ThumbUpRecordDoc> thumbUpRecordDocsPage) {
        /* Gen by Vizend Studio v5.1.0 */
        List<ThumbUpRecordDoc> thumbUpRecordDocs = thumbUpRecordDocsPage.getContent();
        List<ThumbUpRecord> thumbUpRecords = toDomains(thumbUpRecordDocs);
        return new PageImpl<>(thumbUpRecords, thumbUpRecordDocsPage.getPageable(), thumbUpRecordDocsPage.getTotalElements());
    }

    public static Slice<ThumbUpRecord> toDomains(Slice<ThumbUpRecordDoc> thumbUpRecordDocsSlice) {
        /* Gen by Vizend Studio v5.1.0 */
        List<ThumbUpRecordDoc> thumbUpRecordDocs = thumbUpRecordDocsSlice.getContent();
        List<ThumbUpRecord> thumbUpRecords = toDomains(thumbUpRecordDocs);
        return new SliceImpl<>(thumbUpRecords, thumbUpRecordDocsSlice.getPageable(), thumbUpRecordDocsSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static ThumbUpRecordDoc sample() {
        /* Gen by Vizend Studio v5.1.0 */
        return new ThumbUpRecordDoc(ThumbUpRecord.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sample());
    }
}
