/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.event;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.message.DataEvent;
import io.vizend.board.aggregate.post.domain.entity.ThumbUpRecord;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class ThumbUpRecordEvent extends DataEvent {
    /* Gen by Vizend Studio v5.1.0 */
    private ThumbUpRecord thumbUpRecord;
    private String thumbUpRecordId;
    private NameValueList nameValues;

    protected ThumbUpRecordEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Studio v5.1.0 */
        super(type, entity);
    }

    public static ThumbUpRecordEvent newThumbUpRecordRegisteredEvent(ThumbUpRecord thumbUpRecord, String thumbUpRecordId) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecordEvent event = new ThumbUpRecordEvent(DataEventType.Registered, thumbUpRecord);
        event.setThumbUpRecord(thumbUpRecord);
        event.setThumbUpRecordId(thumbUpRecordId);
        return event;
    }

    public static ThumbUpRecordEvent newThumbUpRecordModifiedEvent(String thumbUpRecordId, NameValueList nameValues, ThumbUpRecord thumbUpRecord) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecordEvent event = new ThumbUpRecordEvent(DataEventType.Modified, thumbUpRecord);
        event.setThumbUpRecordId(thumbUpRecordId);
        event.setNameValues(nameValues);
        event.setThumbUpRecord(thumbUpRecord);
        return event;
    }

    public static ThumbUpRecordEvent newThumbUpRecordRemovedEvent(ThumbUpRecord thumbUpRecord, String thumbUpRecordId) {
        /* Gen by Vizend Studio v5.1.0 */
        ThumbUpRecordEvent event = new ThumbUpRecordEvent(DataEventType.Removed, thumbUpRecord);
        event.setThumbUpRecord(thumbUpRecord);
        event.setThumbUpRecordId(thumbUpRecordId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static ThumbUpRecordEvent fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, ThumbUpRecordEvent.class);
    }
}
