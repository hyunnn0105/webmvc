package com.spring.webmvc.springmvc.chap02.mybatis.repository;

import com.spring.webmvc.springmvc.chap02.mybatis.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("값이 들어가야 한다")
    void insertTest(){
        Score score = new Score("gkgkgk", 99, 99 ,88);
//        score.setName("하하하");
//        score.setKor(13);
//        score.setEng(23);
//        score.setMath(56);

        boolean save = mapper.save(score);

        assertTrue(save);
    }

    @Test
    @DisplayName("지정한 값을 삭제해야한다")
    void deleteTest(){
        boolean remove = mapper.remove(11);

        assertTrue(remove);
    }

    /*
    @Test
    @DisplayName("지정한 값을 가져와야한다")
    void findAllTest(){
        mapper.findAll().forEach(System.out::println);


    }

     */

    @Test
    @DisplayName("하나만 조회한다")
    void findOneTest(){
        Score one = mapper.findOne(10);
        System.out.println(one);
    }

}