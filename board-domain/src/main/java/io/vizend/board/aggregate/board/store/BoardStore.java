/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store;

import io.vizend.board.aggregate.board.domain.entity.Board;
import java.util.List;

public interface BoardStore {
    /* Gen by Vizend Studio v5.1.0 */
    void create(Board board);
    void createAll(List<Board> boards);
    Board retrieve(String id);
    List<Board> retrieveAll(List<String> boardIds);
    void update(Board board);
    void delete(Board board);
    void delete(String id);
    boolean exists(String id);
}
