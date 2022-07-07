package com.spring.webmvc.chap04;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private View view; // view기능 포함
    // jsp(= view templet)에게 데이터를 전송할 모델 객체
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName){
        this.view = new View(viewName);
    }
    
    // 모델 객체에 데이터를 추가하는 메서드 = process
    public void addAttribute(String key, Object o){
        model.put(key, o);
    }

}
