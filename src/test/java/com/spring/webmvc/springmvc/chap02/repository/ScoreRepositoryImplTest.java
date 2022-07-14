package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 의존성 주입을 테스트 라인에서 사용가능
class ScoreRepositoryImplTest {


    // 구현체를 컨테이너에 등록 -> IMpl에 @REpository 등록
    @Autowired
    ScoreRepository repository;

    @Test
    @DisplayName("점수정보가 데이터베이스 테이블에 삽입되어야한다")
    void saveTest(){
        Score s = new Score("나나나", 80, 90, 70);
        boolean result = repository.save(s);
        assertTrue(result);
    }

    @Test
    @DisplayName("특정 학번에 해당하는 점수정보가 테이블에서 삭제되어야한다")
//    test 통과할 시 이전 상태로 복구
    @Transactional
    @Rollback
    void removeTest(){
        // given
        int stuNum = 2;
        //when
        boolean result = repository.remove(stuNum);
        // then
        assertTrue(result);

    }

    /*
    @Test
    @DisplayName("모든 점수 정보를 조회해야 한다")
    void findAllTest(){
        List<Score> scoreList = repository.findAll();
        // iter score 꺼내기
        for (Score score : scoreList) {
            System.out.println(score);
        }
    }

     */

    @Test
    @DisplayName("특정 학번에 대한 점수정보를 조회해야 한다")
    void findOneTest(){
        Score score = repository.findOne(3);
        System.out.println(score);
        assertEquals("짹짹이", score.getName());
    }
    
    
}