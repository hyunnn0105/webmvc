package com.spring.webmvc.springmvc.chap02.mybatis.repository;

import com.spring.webmvc.springmvc.chap02.mybatis.domain.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 학생의 성적정보를 저장, 조회, 수정, 삭제 하는 저장소 역할

@Mapper
public interface ScoreMapper {

    // 점수 저장
    boolean save(Score score);
    
    // 전체점수 정보 조회

    List<Score> findAll(String sort);

    // 개별점수 조회
    Score findOne(int stuNum);

    // 점수정보 삭제
    boolean remove(int stuNum);
    
    // 수정
//    Score modify(Score score);
}
