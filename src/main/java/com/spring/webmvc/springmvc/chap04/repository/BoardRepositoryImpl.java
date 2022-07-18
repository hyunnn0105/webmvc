package com.spring.webmvc.springmvc.chap04.repository;

import com.spring.webmvc.springmvc.chap04.domain.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Getter @Setter
@Log4j2
public class BoardRepositoryImpl implements Boardrepository{

    private final JdbcTemplate template;

    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO board (board_no, writer, title, content) VALUES (seq_board.NEXTVAL, ?,?,?)";
        log.info("board - {}", board);
        return template.update(sql, board.getWriter(), board.getTitle(), board.getContent()) == 1;
    }

    // 전체조회!! rs 맵핑>?
    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM board ORDER BY board_no DESC";

        return template.query(sql, (rs, rowNum) -> new Board(rs));
    }

    // 삭제기능
    @Override
    public boolean delete(int boardNo) {
        String sql = "DELETE FROM board WHERE board_no=?";
        return template.update(sql, boardNo) == 1;
    }

    @Override
    public Board findOne(int boardNo) {
        String sql = "SELECT * FROM board " +
                "WHERE board_no=?";
        return template.queryForObject(sql, (rs, rowNum) -> new Board(rs), boardNo);
    }

    @Override
    public boolean modify(Board board) {
        String sql = "UPDATE board SET writer =?, title =?, content =? " +
                "WHERE board_no =?";
        return template.update(sql, board.getWriter(), board.getTitle(), board.getContent(), board.getBoardNo())==1;
    }

    @Override
    public int viewCnt(int boardNo) {
            String sql = "  update board set view_cnt = view_cnt + 1 where board_no = ?";
            return template
    }
}
