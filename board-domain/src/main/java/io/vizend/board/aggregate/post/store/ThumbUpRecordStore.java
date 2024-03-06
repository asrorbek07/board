/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.store;

import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import java.util.List;

public interface ThumbUpRecordStore {
    /* Gen by Vizend Studio v5.1.0 */
    void create(ThumbUpRecord thumbUpRecord);
    void createAll(List<ThumbUpRecord> thumbUpRecords);
    ThumbUpRecord retrieve(String id);
    List<ThumbUpRecord> retrieveAll(List<String> thumbUpRecordIds);
    void update(ThumbUpRecord thumbUpRecord);
    void delete(ThumbUpRecord thumbUpRecord);
    void delete(String id);
    boolean exists(String id);
}
