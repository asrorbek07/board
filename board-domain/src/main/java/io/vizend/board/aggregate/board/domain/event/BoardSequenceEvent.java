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
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class BoardSequenceEvent extends DataEvent {
    /* Gen by Vizend Studio v5.1.0 */
    private BoardSequence boardSequence;
    private String boardSequenceId;
    private NameValueList nameValues;

    protected BoardSequenceEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Studio v5.1.0 */
        super(type, entity);
    }

    public static BoardSequenceEvent newBoardSequenceRegisteredEvent(BoardSequence boardSequence, String boardSequenceId) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequenceEvent event = new BoardSequenceEvent(DataEventType.Registered, boardSequence);
        event.setBoardSequence(boardSequence);
        event.setBoardSequenceId(boardSequenceId);
        return event;
    }

    public static BoardSequenceEvent newBoardSequenceModifiedEvent(String boardSequenceId, NameValueList nameValues, BoardSequence boardSequence) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequenceEvent event = new BoardSequenceEvent(DataEventType.Modified, boardSequence);
        event.setBoardSequenceId(boardSequenceId);
        event.setNameValues(nameValues);
        event.setBoardSequence(boardSequence);
        return event;
    }

    public static BoardSequenceEvent newBoardSequenceRemovedEvent(BoardSequence boardSequence, String boardSequenceId) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequenceEvent event = new BoardSequenceEvent(DataEventType.Removed, boardSequence);
        event.setBoardSequence(boardSequence);
        event.setBoardSequenceId(boardSequenceId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static BoardSequenceEvent fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, BoardSequenceEvent.class);
    }
}
