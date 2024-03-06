/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.domain.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.vizend.board.aggregate.board.store.BoardSequenceStore;
import io.vizend.board.aggregate.board.store.BoardSequenceOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardSequenceCdo;
import io.vizend.board.aggregate.board.domain.event.BoardSequenceEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
public class BoardSequenceLogic {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardSequenceStore boardSequenceStore;
    private final BoardSequenceOptionStore boardSequenceOptionStore;
    private final EventProxy eventProxy;

    public BoardSequenceLogic(BoardSequenceStore boardSequenceStore, BoardSequenceOptionStore boardSequenceOptionStore, EventProxy eventProxy) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardSequenceStore = boardSequenceStore;
        this.boardSequenceOptionStore = boardSequenceOptionStore;
        this.eventProxy = eventProxy;
    }

    public String registerBoardSequence(BoardSequenceCdo boardSequenceCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequence boardSequence = new BoardSequence(boardSequenceCdo);
        if (boardSequenceCdo.hasAdditionalAttributes()) {
            boardSequence.modify(boardSequenceCdo.getAdditionalAttributes());
        }
        if (boardSequenceStore.exists(boardSequence.getId())) {
            throw new IllegalArgumentException("boardSequence already exists. " + boardSequence.getId());
        }
        boardSequenceStore.create(boardSequence);
        BoardSequenceEvent boardSequenceEvent = BoardSequenceEvent.newBoardSequenceRegisteredEvent(boardSequence, boardSequence.getId());
        eventProxy.publishEvent(boardSequenceEvent);
        return boardSequence.getId();
    }

    public List<String> registerBoardSequences(List<BoardSequenceCdo> boardSequenceCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardSequenceCdos.stream().map(this::registerBoardSequence).collect(Collectors.toList());
    }

    public BoardSequence findBoardSequence(String boardSequenceId) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequence boardSequence = boardSequenceStore.retrieve(boardSequenceId);
        if (boardSequence == null) {
            throw new NoSuchElementException("BoardSequence id: " + boardSequenceId);
        }
        return boardSequence;
    }

    public void modifyBoardSequence(String boardSequenceId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequence boardSequence = findBoardSequence(boardSequenceId);
        boardSequence.modify(nameValues);
        boardSequenceStore.update(boardSequence);
        BoardSequenceEvent boardSequenceEvent = BoardSequenceEvent.newBoardSequenceModifiedEvent(boardSequenceId, nameValues, boardSequence);
        eventProxy.publishEvent(boardSequenceEvent);
    }

    public void modifyBoardSequence(BoardSequence boardSequence) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequence oldBoardSequence = findBoardSequence(boardSequence.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldBoardSequence, boardSequence);
        if (nameValues.size() > 0) {
            modifyBoardSequence(boardSequence.getId(), nameValues);
        }
    }

    public void removeBoardSequence(String boardSequenceId) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardSequence boardSequence = findBoardSequence(boardSequenceId);
        boardSequenceStore.delete(boardSequence);
        BoardSequenceEvent boardSequenceEvent = BoardSequenceEvent.newBoardSequenceRemovedEvent(boardSequence, boardSequence.getId());
        eventProxy.publishEvent(boardSequenceEvent);
    }

    public boolean existsBoardSequence(String boardSequenceId) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardSequenceStore.exists(boardSequenceId);
    }

    public void handleEventForProjection(BoardSequenceEvent boardSequenceEvent) {
        /* Gen by Vizend Studio v5.1.0 */
        switch(boardSequenceEvent.getDataEventType()) {
            case Registered:
                boardSequenceStore.create(boardSequenceEvent.getBoardSequence());
                break;
            case Modified:
                BoardSequence boardSequence = boardSequenceStore.retrieve(boardSequenceEvent.getBoardSequenceId());
                boardSequence.modify(boardSequenceEvent.getNameValues());
                boardSequenceStore.update(boardSequence);
                break;
            case Removed:
                boardSequenceStore.delete(boardSequenceEvent.getBoardSequenceId());
                break;
        }
    }

    public BoardSequence findByEntityName(String entityName) {
        BoardSequence boardSequence =  boardSequenceOptionStore.retrieveByEntityName( entityName);
    }
}
