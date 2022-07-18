package com.spring.webmvc.springmvc.chap04.repository;

import com.spring.webmvc.springmvc.chap04.domain.Board;

import java.util.List;

public interface Boardrepository {

    // 글 작성
    boolean save(Board board);

    // 전체보기 - 메인
    List<Board> findAll();

    // 삭제
    boolean delete(int boardNo);

    // 하나보여주기
    Board findOne(int boardNo);

    // 수정
    boolean modify(Board board);

    // 조회수
    int viewCnt(int boardNo);

}
