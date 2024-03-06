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
package io.vizend.board.facade.event.projection;

import io.vizend.board.aggregate.board.domain.logic.BoardLogic;
import io.vizend.accent.domain.message.DataEvent;
import io.vizend.board.aggregate.board.domain.event.BoardEvent;
import io.vizend.board.aggregate.board.domain.event.BoardSequenceEvent;
import io.vizend.board.aggregate.board.domain.logic.BoardSequenceLogic;
import io.vizend.board.aggregate.post.domain.event.CommentEvent;
import io.vizend.board.aggregate.post.domain.logic.CommentLogic;
import io.vizend.board.aggregate.post.domain.event.PostEvent;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.aggregate.post.domain.event.ReadCheckEvent;
import io.vizend.board.aggregate.post.domain.logic.ReadCheckLogic;
import io.vizend.board.aggregate.post.domain.event.ReplyEvent;
import io.vizend.board.aggregate.post.domain.logic.ReplyLogic;
import io.vizend.board.aggregate.post.domain.event.ThumbUpRecordEvent;
import io.vizend.board.aggregate.post.domain.logic.ThumbUpRecordLogic;

public class ProjectionHandler {
    private final BoardLogic boardLogic;
    private final BoardSequenceLogic boardSequenceLogic;
    private final CommentLogic commentLogic;
    private final PostLogic postLogic;
    private final ReadCheckLogic readCheckLogic;
    private final ReplyLogic replyLogic;
    private final ThumbUpRecordLogic thumbUpRecordLogic;

    public ProjectionHandler(BoardLogic boardLogic, BoardSequenceLogic boardSequenceLogic, CommentLogic commentLogic, PostLogic postLogic, ReadCheckLogic readCheckLogic, ReplyLogic replyLogic, ThumbUpRecordLogic thumbUpRecordLogic) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardLogic = boardLogic;
        this.boardSequenceLogic = boardSequenceLogic;
        this.commentLogic = commentLogic;
        this.postLogic = postLogic;
        this.readCheckLogic = readCheckLogic;
        this.replyLogic = replyLogic;
        this.thumbUpRecordLogic = thumbUpRecordLogic;
    }

    public void handle(DataEvent event) {
        /* Gen by Vizend Studio v5.1.0 */
        String classFullName = event.getClass().getName();
        String eventName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
        switch(eventName) {
            case "BoardEvent":
                BoardEvent boardEvent = (BoardEvent) event;
                boardLogic.handleEventForProjection(boardEvent);
                break;
        }
    }
}
