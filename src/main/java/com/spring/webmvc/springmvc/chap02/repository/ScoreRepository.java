package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;

import java.util.List;

// 학생의 성적정보를 저장, 조회, 수정, 삭제 하는 저장소 역할
public interface ScoreRepository {

    // 점수 저장
    boolean save(Score score);
    
    // 전체점수 정보 조회
    List<Score> findAll();

    // 개별점수 조회
    Score findOne(int stuNum);

    // 점수정보 삭제
    boolean remove(int stuNum);
}
