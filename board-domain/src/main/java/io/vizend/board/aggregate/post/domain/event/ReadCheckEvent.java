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
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.domain.message.DataEventType;
import io.vizend.accent.domain.entity.DomainEntity;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
public class ReadCheckEvent extends DataEvent {
    /* Gen by Vizend Studio v5.1.0 */
    private ReadCheck readCheck;
    private String readCheckId;
    private NameValueList nameValues;

    protected ReadCheckEvent(DataEventType type, DomainEntity entity) {
        /* Gen by Vizend Studio v5.1.0 */
        super(type, entity);
    }

    public static ReadCheckEvent newReadCheckRegisteredEvent(ReadCheck readCheck, String readCheckId) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheckEvent event = new ReadCheckEvent(DataEventType.Registered, readCheck);
        event.setReadCheck(readCheck);
        event.setReadCheckId(readCheckId);
        return event;
    }

    public static ReadCheckEvent newReadCheckModifiedEvent(String readCheckId, NameValueList nameValues, ReadCheck readCheck) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheckEvent event = new ReadCheckEvent(DataEventType.Modified, readCheck);
        event.setReadCheckId(readCheckId);
        event.setNameValues(nameValues);
        event.setReadCheck(readCheck);
        return event;
    }

    public static ReadCheckEvent newReadCheckRemovedEvent(ReadCheck readCheck, String readCheckId) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheckEvent event = new ReadCheckEvent(DataEventType.Removed, readCheck);
        event.setReadCheck(readCheck);
        event.setReadCheckId(readCheckId);
        return event;
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static ReadCheckEvent fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, ReadCheckEvent.class);
    }
}
