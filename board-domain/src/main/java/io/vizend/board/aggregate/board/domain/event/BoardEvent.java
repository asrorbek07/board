/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.domain.event;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.message.DataEvent;
import io.vizend.board.aggregate.board.domain.entity.Board;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class BoardEvent extends DataEvent {
    /* Gen by Vizend Studio v5.1.0 */
    private Board board;
    private String boardId;
    private NameValueList nameValues;

    protected BoardEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Studio v5.1.0 */
        super(type, entity);
    }

    public static BoardEvent newBoardRegisteredEvent(Board board, String boardId) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardEvent event = new BoardEvent(DataEventType.Registered, board);
        event.setBoard(board);
        event.setBoardId(boardId);
        return event;
    }

    public static BoardEvent newBoardModifiedEvent(String boardId, NameValueList nameValues, Board board) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardEvent event = new BoardEvent(DataEventType.Modified, board);
        event.setBoardId(boardId);
        event.setNameValues(nameValues);
        event.setBoard(board);
        return event;
    }

    public static BoardEvent newBoardRemovedEvent(Board board, String boardId) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardEvent event = new BoardEvent(DataEventType.Removed, board);
        event.setBoard(board);
        event.setBoardId(boardId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static BoardEvent fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, BoardEvent.class);
    }
}
