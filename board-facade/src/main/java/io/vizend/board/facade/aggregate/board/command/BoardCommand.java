/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.facade.aggregate.board.command;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import io.vizend.accent.domain.annotation.AuthorizedRole;
import io.vizend.board.facade.BoardRole;
import io.vizend.accent.domain.message.CommandRequest;
import io.vizend.board.aggregate.board.domain.entity.sdo.BoardCdo;
import java.util.List;
import io.vizend.accent.domain.type.NameValueList;
import io.vizend.accent.util.json.JsonUtil;

@Getter
@Setter
@NoArgsConstructor
@AuthorizedRole(BoardRole.Director)
public class BoardCommand extends CommandRequest {
    /* Gen by Vizend Studio v5.1.0 */
    private BoardCdo boardCdo;
    private List<BoardCdo> boardCdos;
    private boolean multiCdo;
    private String boardId;
    private NameValueList nameValues;

    @Override
    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static BoardCommand newRegisterBoardCommand(BoardCdo boardCdo) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardCommand command = new BoardCommand();
        command.setBoardCdo(boardCdo);
        return command;
    }

    public static BoardCommand newRegisterBoardCommand(List<BoardCdo> boardCdos) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardCommand command = new BoardCommand();
        command.setBoardCdos(boardCdos);
        command.setMultiCdo(true);
        return command;
    }

    public static BoardCommand newModifyBoardCommand(String boardId, NameValueList nameValues) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardCommand command = new BoardCommand();
        command.setBoardId(boardId);
        command.setNameValues(nameValues);
        return command;
    }

    public static BoardCommand newRemoveBoardCommand(String boardId) {
        /* Gen by Vizend Studio v5.1.0 */
        BoardCommand command = new BoardCommand();
        command.setBoardId(boardId);
        return command;
    }

    public static BoardCommand fromJson(String json) {
        /* Gen by Vizend Studio v5.1.0 */
        return JsonUtil.fromJson(json, BoardCommand.class);
    }

    public static BoardCommand sampleForRegister() {
        /* Gen by Vizend Studio v5.1.0 */
        return newRegisterBoardCommand(BoardCdo.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sampleForRegister());
    }
}
