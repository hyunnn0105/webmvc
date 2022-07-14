package com.spring.webmvc.springmvc.chap04.service;

import com.spring.webmvc.springmvc.chap04.domain.Board;
import com.spring.webmvc.springmvc.chap04.repository.Boardrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //스프링 빈 등록
@RequiredArgsConstructor
public class BoardService {

    private final Boardrepository boardrepository;

    // 점수 저장요청 중간처리
    public boolean savewrite(Board board){
        return boardrepository.save(board);
    }

    public Board findOne(int boardNo){
        return boardrepository.findOne(boardNo);
    }
    public boolean delete(int boardNo){
        return boardrepository.delete(boardNo);
    }

    public boolean modify(Board board){
        return boardrepository.modify(board);
    }
}
