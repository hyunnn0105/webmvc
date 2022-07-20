package com.spring.webmvc.springmvc.chap02.mybatis.repository;

import com.spring.webmvc.springmvc.chap02.mybatis.domain.Score;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreRowMapper implements RowMapper<Score> {
    @Override
    public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
        //score 객체를 읽고 맵핑 how -> 값을 줄태니 알아서 채워라
        Score s = new Score(rs);


        return s;
    }
}
