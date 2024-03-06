/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store;

import io.vizend.board.aggregate.board.domain.entity.BoardSequence;

public interface BoardSequenceOptionStore {
    BoardSequence retrieveByEntityName(String entityName);
}
