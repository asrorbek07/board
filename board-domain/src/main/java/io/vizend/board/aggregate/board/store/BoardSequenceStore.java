/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store;

import io.vizend.board.aggregate.board.domain.entity.BoardSequence;
import java.util.List;

public interface BoardSequenceStore {
    /* Gen by Vizend Studio v5.1.0 */
    void create(BoardSequence boardSequence);
    void createAll(List<BoardSequence> boardSequences);
    BoardSequence retrieve(String id);
    List<BoardSequence> retrieveAll(List<String> boardSequenceIds);
    void update(BoardSequence boardSequence);
    void delete(BoardSequence boardSequence);
    void delete(String id);
    boolean exists(String id);
}
