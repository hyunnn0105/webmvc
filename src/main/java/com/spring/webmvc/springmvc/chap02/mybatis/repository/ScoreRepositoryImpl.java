package com.spring.webmvc.springmvc.chap02.mybatis.repository;

import com.spring.webmvc.springmvc.chap02.mybatis.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor // final필드를 매개변수로 초기화해주는 생성자 선언
public class ScoreRepositoryImpl implements ScoreRepository{

    // 스프링 JDBC (중복코드를 줄여줌) : JDBC를 단순화
    private final JdbcTemplate template;

    // 생성자 초기화 -> @RequiredArgsConstructor 이걸로 대채됨

    @Override
    public boolean save(Score score) {
        String sql = "INSERT INTO tbl_score " +
                "VALUES (seq_tbl_score.nextval, ?,?,?,?,?,?,?)";
        // INSERT, UPDATE, DELETE는 templet의 update 메서드 활용
        return template.update(sql, score.getName(), score.getKor(), score.getEng(), score.getMath()
        , score.getTotal(), score.getAverage(), score.getGrade().toString()) == 1;
        // 삽입한 행의 수 - t/f 분별가능
        // score.getGrade().toString() -> char로 들어가게 하기
    }

    @Override
    public List<Score> findAll(String sort) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tbl_score");

        switch (sort) {
            case "num":
                sql.append(" ORDER BY stu_num");
                break;
            case "name":
                sql.append(" ORDER BY stu_name");
                break;
            case "average":
                sql.append(" ORDER BY average DESC");
                break;
        }
        return template.query(sql.toString(), (rs, rowNum) -> new Score(rs));
    }

/*
    @Override
    public List<Score> findAll() {
        String sql = "SELECT * FROM tbl_score";
        // SELECT문은 그냥 쿼리 사용!
        // resultSet .=. rowMapper
        // 순수구현체
//        return template.query(sql, new ScoreRowMapper());
          /*

            return template.query(sql, new RowMapper<Score>() {
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });




        // 람다
        return template.query(sql, (rs, rowNum) -> new Score(rs));
    }

 */
    @Override
    public Score findOne(int stuNum) {
        String sql = "SELECT * FROM tbl_score WHERE stu_num=?";
        // 단일조회시 사용
//        return template.queryForObject(sql, new ScoreRowMapper(), stuNum);
        return template.queryForObject(sql, (rs, rowNum) -> new Score(rs), stuNum);
    }

    // tkr
    @Override
    public boolean remove(int stuNum) {
        String sql = "DELETE FROM tbl_score WHERE stu_num=?";
        return template.update(sql, stuNum) == 1;
    }
    //IMpl -> 구현 임플리먼트
}

