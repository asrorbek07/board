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
import io.vizend.board.aggregate.post.domain.entity.Comment;
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
@Document(collection = "COMMENT")
public class CommentDoc extends StageEntityDoc {
    /* Gen by Vizend Studio v5.1.0 */
    private String text; // 
    private String displayName;
    private boolean accepted;
    private String postId;

    public CommentDoc(Comment comment) {
        /* Gen by Vizend Studio v5.1.0 */
        super(comment);
        BeanUtils.copyProperties(comment, this);
    }

    public Comment toDomain() {
        /* Gen by Vizend Studio v5.1.0 */
        Comment comment = new Comment(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, comment);
        return comment;
    }

    public static List<Comment> toDomains(List<CommentDoc> commentDocs) {
        /* Gen by Vizend Studio v5.1.0 */
        return commentDocs.stream().map(CommentDoc::toDomain).collect(Collectors.toList());
    }

    public static Page<Comment> toDomains(Page<CommentDoc> commentDocsPage) {
        /* Gen by Vizend Studio v5.1.0 */
        List<CommentDoc> commentDocs = commentDocsPage.getContent();
        List<Comment> comments = toDomains(commentDocs);
        return new PageImpl<>(comments, commentDocsPage.getPageable(), commentDocsPage.getTotalElements());
    }

    public static Slice<Comment> toDomains(Slice<CommentDoc> commentDocsSlice) {
        /* Gen by Vizend Studio v5.1.0 */
        List<CommentDoc> commentDocs = commentDocsSlice.getContent();
        List<Comment> comments = toDomains(commentDocs);
        return new SliceImpl<>(comments, commentDocsSlice.getPageable(), commentDocsSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static CommentDoc sample() {
        /* Gen by Vizend Studio v5.1.0 */
        return new CommentDoc(Comment.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sample());
    }
}
