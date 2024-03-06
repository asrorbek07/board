/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.board.aggregate.board.store.mongo.odm;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import io.vizend.accent.store.mongo.StageEntityDoc;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardType;
import io.vizend.board.aggregate.board.domain.entity.vo.BoardPolicy;
import io.vizend.board.aggregate.board.domain.entity.Board;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "BOARD")
public class BoardDoc extends StageEntityDoc {
    /* Gen by Vizend Studio v5.1.0 */
    private String title; // 
    private String description;
    private BoardType boardType;
    private BoardPolicy boardPolicy;
    private long postSequence;

    public BoardDoc(Board board) {
        /* Gen by Vizend Studio v5.1.0 */
        super(board);
        BeanUtils.copyProperties(board, this);
    }

    public Board toDomain() {
        /* Gen by Vizend Studio v5.1.0 */
        Board board = new Board(getId(), genRequesterKey());
        BeanUtils.copyProperties(this, board);
        return board;
    }

    public static List<Board> toDomains(List<BoardDoc> boardDocs) {
        /* Gen by Vizend Studio v5.1.0 */
        return boardDocs.stream().map(BoardDoc::toDomain).collect(Collectors.toList());
    }

    public static Page<Board> toDomains(Page<BoardDoc> boardDocsPage) {
        /* Gen by Vizend Studio v5.1.0 */
        List<BoardDoc> boardDocs = boardDocsPage.getContent();
        List<Board> boards = toDomains(boardDocs);
        return new PageImpl<>(boards, boardDocsPage.getPageable(), boardDocsPage.getTotalElements());
    }

    public static Slice<Board> toDomains(Slice<BoardDoc> boardDocsSlice) {
        /* Gen by Vizend Studio v5.1.0 */
        List<BoardDoc> boardDocs = boardDocsSlice.getContent();
        List<Board> boards = toDomains(boardDocs);
        return new SliceImpl<>(boards, boardDocsSlice.getPageable(), boardDocsSlice.hasNext());
    }

    public String toString() {
        /* Gen by Vizend Studio v5.1.0 */
        return toJson();
    }

    public static BoardDoc sample() {
        /* Gen by Vizend Studio v5.1.0 */
        return new BoardDoc(Board.sample());
    }

    public static void main(String[] args) {
        /* Gen by Vizend Studio v5.1.0 */
        System.out.println(sample());
    }
}
