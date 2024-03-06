/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store;

import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import java.util.List;

public interface ReadCheckStore {
    /* Gen by Vizend Studio v5.1.0 */
    void create(ReadCheck readCheck);
    void createAll(List<ReadCheck> readChecks);
    ReadCheck retrieve(String id);
    List<ReadCheck> retrieveAll(List<String> readCheckIds);
    void update(ReadCheck readCheck);
    void delete(ReadCheck readCheck);
    void delete(String id);
    boolean exists(String id);
}
