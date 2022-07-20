package com.spring.webmvc.springmvc.chap05.mybatis.repository;

import com.spring.webmvc.springmvc.chap04.domain.Board;
import com.spring.webmvc.springmvc.chap05.mybatis.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    @DisplayName("값이 들어가야한다")
    void saveTest(){
        for (int i = 1; i <= 10 ; i++) {
            Product pro = new Product();
            pro.setProductName("좋은제품" +i);
            pro.setPrice(10000 + 100 * i);

            productMapper.save(pro);
        }
    }

    @Test
    @DisplayName("값이 삭제되어야 한다.")
    void removeTest(){
        boolean flag = productMapper.remove("202207200007");

        assertTrue(flag);

    }

    @Test
    @DisplayName("값이 수정되어야 한다.")
    void modifyTest(){

        Product pro = new Product();
        pro.setSerialNo("202207200005");
        pro.setProductName("수정제품");
        pro.setPrice(99999);

        boolean flag = productMapper.modify(pro);

        assertTrue(flag);

    }

    /*
    @Test
    @DisplayName("제품 정보를 전체 조회해야 한다.")
    void findAllTest() {

        ProductMapper.findAll().forEach(System.out::println);
    }

     */

    @Test
    @DisplayName("제품 정보를 개별 조회해야 한다.")
    void findOneTest() {

        Product product = productMapper.findOne("202207200009");
        System.out.println("product = " + product);
    }





}