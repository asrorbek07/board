/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.feature.notice.post.rest;

import io.vizend.board.feature.notice.post.domain.sdo.NoticePostRdo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import io.vizend.board.feature.notice.post.flow.NoticePostSeek;
import io.vizend.accent.domain.message.QueryResponse;
import io.vizend.board.aggregate.post.domain.entity.Post;
import io.vizend.board.facade.feature.notice.post.query.FindNoticePostQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import io.vizend.board.facade.feature.notice.post.query.FindNoticePostsQuery;

@RestController
@RequestMapping("/feature/notice/post")
@RequiredArgsConstructor
public class NoticePostSeekResource implements NoticePostSeekFacade {
    private final NoticePostSeek noticePostSeek;

    @Override
    @PostMapping("/find-notice-post/query")
    public QueryResponse<NoticePostRdo> findNoticePost(@RequestBody FindNoticePostQuery query) {
        //
        query.validate();
        String postId = query.getPostId();
        NoticePostRdo response = noticePostSeek.findNoticePost(postId);
        query.setResponse(response);
        return query.getResponse();
    }

    @Override
    @PostMapping("/find-notice-posts/query")
    public QueryResponse<List<NoticePostRdo>> findNoticePosts(@RequestBody FindNoticePostsQuery query) {
        //
        query.validate();
        String boardId = query.getBoardId();
        List<NoticePostRdo> response = noticePostSeek.findNoticePosts(boardId);
        query.setResponse(response);
        return query.getResponse();
    }
}
