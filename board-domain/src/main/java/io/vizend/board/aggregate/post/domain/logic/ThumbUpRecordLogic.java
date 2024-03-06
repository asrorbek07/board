/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.vizend.board.aggregate.post.store.ThumbUpRecordStore;
import io.vizend.board.aggregate.post.store.ThumbUpRecordOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.board.aggregate.post.domain.entity.sdo.ThumbUpRecordCdo;
import io.vizend.board.aggregate.post.domain.event.ThumbUpRecordEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
public class ThumbUpRecordLogic {
    /* Gen by Vizend Studio v5.1.0 */
    private final ThumbUpRecordStore thumbUpRecordStore;
    private final ThumbUpRecordOptionStore thumbUpRecordOptionStore;
    private final EventProxy eventProxy;

    public ThumbUpRecordLogic(ThumbUpRecordStore thumbUpRecordStore, ThumbUpRecordOptionStore thumbUpRecordOptionStore, EventProxy eventProxy) {
        /* Gen by Vizend Studio v5.1.0 */
        this.thumbUpRecordStore = thumbUpRecordStore;
        this.thumbUpRecordOptionStore = thumbUpRecordOptionStore;
        this.eventProxy = eventProxy;
    }

    public String registerThumbUpRecord(ThumbUpRecordCdo thumbUpRecordCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecord thumbUpRecord = new ThumbUpRecord(thumbUpRecordCdo);
        if (thumbUpRecordCdo.hasAdditionalAttributes()) {
            thumbUpRecord.modify(thumbUpRecordCdo.getAdditionalAttributes());
        }
        if (thumbUpRecordStore.exists(thumbUpRecord.getId())) {
            throw new IllegalArgumentException("thumbUpRecord already exists. " + thumbUpRecord.getId());
        }
        thumbUpRecordStore.create(thumbUpRecord);
        ThumbUpRecordEvent thumbUpRecordEvent = ThumbUpRecordEvent.newThumbUpRecordRegisteredEvent(thumbUpRecord, thumbUpRecord.getId());
        eventProxy.publishEvent(thumbUpRecordEvent);
        return thumbUpRecord.getId();
    }

    public List<String> registerThumbUpRecords(List<ThumbUpRecordCdo> thumbUpRecordCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        return thumbUpRecordCdos.stream().map(this::registerThumbUpRecord).collect(Collectors.toList());
    }

    public ThumbUpRecord findThumbUpRecord(String thumbUpRecordId) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecord thumbUpRecord = thumbUpRecordStore.retrieve(thumbUpRecordId);
        if (thumbUpRecord == null) {
            throw new NoSuchElementException("ThumbUpRecord id: " + thumbUpRecordId);
        }
        return thumbUpRecord;
    }

    public void modifyThumbUpRecord(String thumbUpRecordId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecord thumbUpRecord = findThumbUpRecord(thumbUpRecordId);
        thumbUpRecord.modify(nameValues);
        thumbUpRecordStore.update(thumbUpRecord);
        ThumbUpRecordEvent thumbUpRecordEvent = ThumbUpRecordEvent.newThumbUpRecordModifiedEvent(thumbUpRecordId, nameValues, thumbUpRecord);
        eventProxy.publishEvent(thumbUpRecordEvent);
    }

    public void modifyThumbUpRecord(ThumbUpRecord thumbUpRecord) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecord oldThumbUpRecord = findThumbUpRecord(thumbUpRecord.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldThumbUpRecord, thumbUpRecord);
        if (nameValues.size() > 0) {
            modifyThumbUpRecord(thumbUpRecord.getId(), nameValues);
        }
    }

    public void removeThumbUpRecord(String thumbUpRecordId) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecord thumbUpRecord = findThumbUpRecord(thumbUpRecordId);
        thumbUpRecordStore.delete(thumbUpRecord);
        ThumbUpRecordEvent thumbUpRecordEvent = ThumbUpRecordEvent.newThumbUpRecordRemovedEvent(thumbUpRecord, thumbUpRecord.getId());
        eventProxy.publishEvent(thumbUpRecordEvent);
    }

    public boolean existsThumbUpRecord(String thumbUpRecordId) {
        /* Gen by Vizend Studio v5.1.0 */
        return thumbUpRecordStore.exists(thumbUpRecordId);
    }

    public void handleEventForProjection(ThumbUpRecordEvent thumbUpRecordEvent) {
        /* Gen by Vizend Studio v5.1.0 */
        switch(thumbUpRecordEvent.getDataEventType()) {
            case Registered:
                thumbUpRecordStore.create(thumbUpRecordEvent.getThumbUpRecord());
                break;
            case Modified:
                ThumbUpRecord thumbUpRecord = thumbUpRecordStore.retrieve(thumbUpRecordEvent.getThumbUpRecordId());
                thumbUpRecord.modify(thumbUpRecordEvent.getNameValues());
                thumbUpRecordStore.update(thumbUpRecord);
                break;
            case Removed:
                thumbUpRecordStore.delete(thumbUpRecordEvent.getThumbUpRecordId());
                break;
        }
    }
}
