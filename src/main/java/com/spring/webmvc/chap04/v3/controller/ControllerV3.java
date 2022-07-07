package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;

import java.util.Map;

public interface ControllerV3 {

    // view를 리턴
    // front컨트롤러한테 정보를 ?넘김

    /**
     *
     * @param paramMap : 요청정보(쿼리파라미터)를 모두 읽어서 맵에 담아줌.
     * @return
     */
    View process(Map<String, String> paramMap);





}
