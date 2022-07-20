package com.spring.webmvc.springmvc.chap05.mybatis.domain;

import lombok.*;

import java.util.Date;

// 필드 == 컬럼
@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String serialNo;
    public String productName;
    private int price;
    private Date madeAt;



}
