/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.domain.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.vizend.board.aggregate.board.store.BoardStore;
import io.vizend.board.aggregate.board.store.BoardOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import io.vizend.board.aggregate.board.domain.event.BoardEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.board.aggregate.board.domain.entity.Board;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
public class BoardLogic {
    /* Gen by Vizend Studio v5.1.0 */
    private final BoardStore boardStore;
    private final BoardOptionStore boardOptionStore;
    private final EventProxy eventProxy;

    public BoardLogic(BoardStore boardStore, BoardOptionStore boardOptionStore, EventProxy eventProxy) {
        /* Gen by Vizend Studio v5.1.0 */
        this.boardStore = boardStore;
        this.boardOptionStore = boardOptionStore;
        this.eventProxy = eventProxy;
    }

    public String registerBoard(BoardCdo boardCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        Board board = new Board(boardCdo);
        if (boardCdo.hasAdditionalAttributes()) {
            board.modify(boardCdo.getAdditionalAttributes());
        }
        if (boardStore.exists(board.getId())) {
            throw new IllegalArgumentException("board already exists. " + board.getId());
        }
        boardStore.create(board);
        BoardEvent boardEvent = BoardEvent.newBoardRegisteredEvent(board, board.getId());
        eventProxy.publishEvent(boardEvent);
        return board.getId();
    }

    public List<String> registerBoards(List<BoardCdo> boardCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardCdos.stream().map(this::registerBoard).collect(Collectors.toList());
    }

    public Board findBoard(String boardId) {
        /* Gen by Vizend Studio v5.1.0 */
        Board board = boardStore.retrieve(boardId);
        if (board == null) {
            throw new NoSuchElementException("Board id: " + boardId);
        }
        return board;
    }

    public void modifyBoard(String boardId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        Board board = findBoard(boardId);
        board.modify(nameValues);
        boardStore.update(board);
        BoardEvent boardEvent = BoardEvent.newBoardModifiedEvent(boardId, nameValues, board);
        eventProxy.publishEvent(boardEvent);
    }

    public void modifyBoard(Board board) {
        /* Gen by Vizend Studio v5.1.0 */
        Board oldBoard = findBoard(board.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldBoard, board);
        if (nameValues.size() > 0) {
            modifyBoard(board.getId(), nameValues);
        }
    }

    public void removeBoard(String boardId) {
        /* Gen by Vizend Studio v5.1.0 */
        Board board = findBoard(boardId);
        boardStore.delete(board);
        BoardEvent boardEvent = BoardEvent.newBoardRemovedEvent(board, board.getId());
        eventProxy.publishEvent(boardEvent);
    }

    public boolean existsBoard(String boardId) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardStore.exists(boardId);
    }

    public void handleEventForProjection(BoardEvent boardEvent) {
        /* Gen by Vizend Studio v5.1.0 */
        switch(boardEvent.getDataEventType()) {
            case Registered:
                boardStore.create(boardEvent.getBoard());
                break;
            case Modified:
                Board board = boardStore.retrieve(boardEvent.getBoardId());
                board.modify(boardEvent.getNameValues());
                boardStore.update(board);
                break;
            case Removed:
                boardStore.delete(boardEvent.getBoardId());
                break;
        }
    }
}
