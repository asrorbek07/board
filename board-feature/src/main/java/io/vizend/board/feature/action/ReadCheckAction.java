package io.vizend.board.feature.action;

import io.vizend.board.aggregate.post.domain.entity.ReadCheck;
import io.vizend.board.aggregate.post.domain.entity.sdo.ReadCheckCdo;
import io.vizend.board.aggregate.post.domain.logic.PostLogic;
import io.vizend.board.aggregate.post.domain.logic.ReadCheckLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class ReadCheckAction {
    //
    private final PostLogic postLogic;
    private final ReadCheckLogic readCheckLogic;

    public String registerReadCheck(ReadCheckCdo readCheckCdo) {
        //
        String postId = readCheckCdo.getPostId();
        validatePost(postId);
        ReadCheck readCheck = readCheckLogic.findReadCheckByPostIdAndReader(readCheckCdo.getPostId(),readCheckCdo.getReader());
        if (readCheck==null) {
            return readCheckLogic.registerReadCheck(readCheckCdo);
        }
        return readCheck.getId();
    }

    public void deleteReadChecks(String postId) {
        validatePost(postId);
        List<ReadCheck> readChecks = findReadChecks(postId);
        for (ReadCheck readCheck : readChecks) {
            readCheckLogic.removeReadCheck(readCheck.getId());
        }
    }
    public List<ReadCheck> findReadChecks(String postId){
        return readCheckLogic.findReadChecks(postId);
    }

    private void validatePost(String postId) {
        if (!postLogic.existsPost(postId)) {
            throw new NoSuchElementException("Post id: " + postId);
        }
    }
}

