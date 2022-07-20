package com.spring.webmvc.springmvc.chap05.mybatis.repository;

import com.spring.webmvc.springmvc.chap05.mybatis.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// = repository
@Mapper // 마이바틱스 동작 인터페이스 등록
public interface ProductMapper {
    // 제품 등록
    boolean save(Product product);
    // 전체조회
    List<Product> findAll();
    // 개별조회
    Product findOne(String serialNo);
    // 수정
    boolean modify(Product product);
    // 삭제
    boolean remove(String serialNo);
}
