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
import io.vizend.board.aggregate.post.domain.entity.vo.PostState;
import io.vizend.board.aggregate.board.domain.entity.vo.CommentRule;
import io.vizend.board.aggregate.post.domain.entity.vo.ReportOption;
import io.vizend.board.aggregate.post.domain.entity.Post;
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
@Document(collection = "POST")
public class PostDoc extends StageEntityDoc {
    /* Gen by Vizend Studio v5.1.0 */
    private long sequence; // 
    private String title;
    private String displayName;
    private String content;
    private PostState postState;
    private CommentRule commentRule;
    private ReportOption reportOption;
    private String boardId;

    public PostDoc(Post post) {
        /* Gen by Vizend Studio v5.1.0 */
        super(post);
        BeanUtils.copyProperties(post, this);
    }

    public Post toDomain() {
        /* Gen by Vizend Studio v5.1.0 */
        Post post = new Post(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, post);
        return post;
    }

    public static List<Post> toDomains(List<PostDoc> postDocs) {
        /* Gen by Vizend Studio v5.1.0 */
        return postDocs.stream().map(PostDoc::toDomain).collect(Collectors.toList());
    }

    public static Page<Post> toDomains(Page<PostDoc> postDocsPage) {
        /* Gen by Vizend Studio v5.1.0 */
        List<PostDoc> postDocs = postDocsPage.getContent();
        List<Post> posts = toDomains(postDocs);
        return new PageImpl<>(posts, postDocsPage.getPageable(), postDocsPage.getTotalElements());
    }

    public static Slice<Post> toDomains(Slice<PostDoc> postDocsSlice) {
        /* Gen by Vizend Studio v5.1.0 */
        List<PostDoc> postDocs = postDocsSlice.getContent();
        List<Post> posts = toDomains(postDocs);
        return new SliceImpl<>(posts, postDocsSlice.getPageable(), postDocsSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static PostDoc sample() {
        /* Gen by Vizend Studio v5.1.0 */
        return new PostDoc(Post.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sample());
    }
}
