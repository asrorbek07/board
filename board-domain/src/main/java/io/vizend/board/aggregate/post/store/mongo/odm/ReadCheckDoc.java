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
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
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
@Document(collection = "READ_CHECK")
public class ReadCheckDoc extends StageEntityDoc {
    /* Gen by Vizend Studio v5.1.0 */
    private String readerId;
    private String readerName;
    private String postId;

    public ReadCheckDoc(ReadCheck readCheck) {
        /* Gen by Vizend Studio v5.1.0 */
        super(readCheck);
        BeanUtils.copyProperties(readCheck, this);
        if (readCheck.getReader() != null) {
            this.readerId = readCheck.getReader().getId();
            this.readerName = readCheck.getReader().getName();
        }
    }

    public ReadCheck toDomain() {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheck readCheck = new ReadCheck(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, readCheck);
        IdName reader = new IdName();
        reader.setId(readerId);
        reader.setName(readerName);
        readCheck.setReader(reader);
        return readCheck;
    }

    public static List<ReadCheck> toDomains(List<ReadCheckDoc> readCheckDocs) {
        /* Gen by Vizend Studio v5.1.0 */
        return readCheckDocs.stream().map(ReadCheckDoc::toDomain).collect(Collectors.toList());
    }

    public static Page<ReadCheck> toDomains(Page<ReadCheckDoc> readCheckDocsPage) {
        /* Gen by Vizend Studio v5.1.0 */
        List<ReadCheckDoc> readCheckDocs = readCheckDocsPage.getContent();
        List<ReadCheck> readChecks = toDomains(readCheckDocs);
        return new PageImpl<>(readChecks, readCheckDocsPage.getPageable(), readCheckDocsPage.getTotalElements());
    }

    public static Slice<ReadCheck> toDomains(Slice<ReadCheckDoc> readCheckDocsSlice) {
        /* Gen by Vizend Studio v5.1.0 */
        List<ReadCheckDoc> readCheckDocs = readCheckDocsSlice.getContent();
        List<ReadCheck> readChecks = toDomains(readCheckDocs);
        return new SliceImpl<>(readChecks, readCheckDocsSlice.getPageable(), readCheckDocsSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static ReadCheckDoc sample() {
        /* Gen by Vizend Studio v5.1.0 */
        return new ReadCheckDoc(ReadCheck.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sample());
    }
}
