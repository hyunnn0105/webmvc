package com.spring.webmvc.springmvc.chap04.repository;

import com.spring.webmvc.springmvc.chap04.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryImplTest {

    @Autowired
    Boardrepository boardrepository;

    @Test
    @DisplayName("값을 넣어야한다.")
    void saveTest(){
        Board b = new Board("작성자2", "제목2", "2222222222");
        boolean result = boardrepository.save(b);

        assertTrue(result);
    }

    @Test
    @DisplayName("값을 넣어야한다.")
    void deleteTest(){

        boolean result = boardrepository.delete(2);

        assertTrue(result);
    }

    @Test
    @DisplayName("값이 동일해야 한다.")
    void findOneTest(){

        Board one = boardrepository.findOne(3);
        System.out.println(one);

        assertEquals("작성자2", one.getWriter());

    }

    @Test
    @DisplayName("값이 동일해야 한다.")
    void findAllTest(){

        List<Board> all = boardrepository.findAll();
        for (Board b : all) {
            System.out.println(b);
        }

        assertEquals(3, all.size());

    }
    @Test
    @DisplayName("값이 수정되어야한다.")
    void modifyTest(){
        Board b = boardrepository.findOne(5);
        b.setWriter("작성자5");
        b.setTitle("제목444");
        b.setContent("4444444");

        boolean result = boardrepository.modify(b);

        assertEquals("작성자5", b.getWriter());

    }

}