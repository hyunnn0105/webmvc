package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor // final필드를 초기화해주는 생성자 선언
public class ScoreRepositoryImpl implements ScoreRepository{

    // 스프링 JDBC (중복코드를 줄여줌) : JDBC를 단순화
    private final JdbcTemplate template;

    // 생성자 초기화 -> @RequiredArgsConstructor 이걸로 대채됨
    /*
    public ScoreRepositoryImpl(JdbcTemplate template){
        this.template = template;
    }
    
     */

    @Override
    public boolean save(Score score) {

        return false;
    }

    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public Score findOne(int stuNum) {
        return null;
    }

    @Override
    public boolean remove(int stuNum) {
        return false;
    }
    //IMpl -> 구현 임플리먼트
}
