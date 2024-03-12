/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.post.domain.logic;

import io.vizend.accent.domain.type.IdName;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.vizend.board.aggregate.post.store.ReadCheckStore;
import io.vizend.board.aggregate.post.store.ReadCheckOptionStore;
import io.vizend.prologue.janitor.proxy.EventProxy;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReadCheckCdo;
import io.vizend.board.aggregate.post.domain.event.ReadCheckEvent;
import io.vizend.accent.domain.tenant.AudienceKey;
import java.util.List;
import java.util.stream.Collectors;
import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import java.util.NoSuchElementException;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.entity.Entities;

@Service
@Transactional
public class ReadCheckLogic {
    /* Gen by Vizend Studio v5.1.0 */
    private final ReadCheckStore readCheckStore;
    private final ReadCheckOptionStore readCheckOptionStore;
    private final EventProxy eventProxy;

    public ReadCheckLogic(ReadCheckStore readCheckStore, ReadCheckOptionStore readCheckOptionStore, EventProxy eventProxy) {
        /* Gen by Vizend Studio v5.1.0 */
        this.readCheckStore = readCheckStore;
        this.readCheckOptionStore = readCheckOptionStore;
        this.eventProxy = eventProxy;
    }

    public String registerReadCheck(ReadCheckCdo readCheckCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheck readCheck = new ReadCheck(readCheckCdo);
        if (readCheckCdo.hasAdditionalAttributes()) {
            readCheck.modify(readCheckCdo.getAdditionalAttributes());
        }
        if (readCheckStore.exists(readCheck.getId())) {
            throw new IllegalArgumentException("readCheck already exists. " + readCheck.getId());
        }
        readCheckStore.create(readCheck);
        ReadCheckEvent readCheckEvent = ReadCheckEvent.newReadCheckRegisteredEvent(readCheck, readCheck.getId());
        eventProxy.publishEvent(readCheckEvent);
        return readCheck.getId();
    }

    public List<String> registerReadChecks(List<ReadCheckCdo> readCheckCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        return readCheckCdos.stream().map(this::registerReadCheck).collect(Collectors.toList());
    }

    public ReadCheck findReadCheck(String readCheckId) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheck readCheck = readCheckStore.retrieve(readCheckId);
        if (readCheck == null) {
            throw new NoSuchElementException("ReadCheck id: " + readCheckId);
        }
        return readCheck;
    }

    public void modifyReadCheck(String readCheckId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheck readCheck = findReadCheck(readCheckId);
        readCheck.modify(nameValues);
        readCheckStore.update(readCheck);
        ReadCheckEvent readCheckEvent = ReadCheckEvent.newReadCheckModifiedEvent(readCheckId, nameValues, readCheck);
        eventProxy.publishEvent(readCheckEvent);
    }

    public void modifyReadCheck(ReadCheck readCheck) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheck oldReadCheck = findReadCheck(readCheck.getId());
        NameValueList nameValues = Entities.getModifiedNameValues(oldReadCheck, readCheck);
        if (nameValues.size() > 0) {
            modifyReadCheck(readCheck.getId(), nameValues);
        }
    }

    public void removeReadCheck(String readCheckId) {
        /* Gen by Vizend Studio v5.1.0 */
        ReadCheck readCheck = findReadCheck(readCheckId);
        readCheckStore.delete(readCheck);
        ReadCheckEvent readCheckEvent = ReadCheckEvent.newReadCheckRemovedEvent(readCheck, readCheck.getId());
        eventProxy.publishEvent(readCheckEvent);
    }

    public boolean existsReadCheck(String readCheckId) {
        /* Gen by Vizend Studio v5.1.0 */
        return readCheckStore.exists(readCheckId);
    }

    public void handleEventForProjection(ReadCheckEvent readCheckEvent) {
        /* Gen by Vizend Studio v5.1.0 */
        switch(readCheckEvent.getDataEventType()) {
            case Registered:
                readCheckStore.create(readCheckEvent.getReadCheck());
                break;
            case Modified:
                ReadCheck readCheck = readCheckStore.retrieve(readCheckEvent.getReadCheckId());
                readCheck.modify(readCheckEvent.getNameValues());
                readCheckStore.update(readCheck);
                break;
            case Removed:
                readCheckStore.delete(readCheckEvent.getReadCheckId());
                break;
        }
    }

    public ReadCheck findReadCheckByPostIdAndReader(String postId, IdName reader) {
        //
        return readCheckOptionStore.findByPostIdAndReader(postId,reader);
    }

    public List<ReadCheck> findReadChecks(String postId) {
        //
        return readCheckOptionStore.retrieveAllByPostId(postId);
    }
}
