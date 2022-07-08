package com.spring.webmvc.servlet.chap04;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Setter @Getter
public class ModelAndView {
    private View view; // view기능 포함
    // jsp(= view templet)에게 데이터를 전송할 모델 객체
    private Model model;

    public ModelAndView(String viewName){
        this.view = new View(viewName);
    }
    
    // 모델 객체에 데이터를 추가하는 메서드 = process
    public void addAttribute(String key, Object o){
        model.getModel().put(key, o);
    }

    // view한테 위임
    public void render(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.view.render(req, resp);
    }

    public Map<String, Object> getModel(){

        return model.getModel();
    }
}
