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
import io.vizend.board.aggregate.post.domain.entity.Reply;
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
@Document(collection = "REPLY")
public class ReplyDoc extends StageEntityDoc {
    /* Gen by Vizend Studio v5.1.0 */
    private String text; // 
    private String displayName;
    private String commentId;

    public ReplyDoc(Reply reply) {
        /* Gen by Vizend Studio v5.1.0 */
        super(reply);
        BeanUtils.copyProperties(reply, this);
    }

    public Reply toDomain() {
        /* Gen by Vizend Studio v5.1.0 */
        Reply reply = new Reply(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, reply);
        return reply;
    }

    public static List<Reply> toDomains(List<ReplyDoc> replyDocs) {
        /* Gen by Vizend Studio v5.1.0 */
        return replyDocs.stream().map(ReplyDoc::toDomain).collect(Collectors.toList());
    }

    public static Page<Reply> toDomains(Page<ReplyDoc> replyDocsPage) {
        /* Gen by Vizend Studio v5.1.0 */
        List<ReplyDoc> replyDocs = replyDocsPage.getContent();
        List<Reply> replys = toDomains(replyDocs);
        return new PageImpl<>(replys, replyDocsPage.getPageable(), replyDocsPage.getTotalElements());
    }

    public static Slice<Reply> toDomains(Slice<ReplyDoc> replyDocsSlice) {
        /* Gen by Vizend Studio v5.1.0 */
        List<ReplyDoc> replyDocs = replyDocsSlice.getContent();
        List<Reply> replys = toDomains(replyDocs);
        return new SliceImpl<>(replys, replyDocsSlice.getPageable(), replyDocsSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static ReplyDoc sample() {
        /* Gen by Vizend Studio v5.1.0 */
        return new ReplyDoc(Reply.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sample());
    }
}
