package com.spring.webmvc.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//공ㅇ용클래스 view 생성
//뷰를 포워딩하는 기능
public class View {
    private String viewName; // 포워딩할 뷰의 경로

    public View(String viewName) {
        this.viewName = viewName;
    }

    //포워딩 기능
    // 준것 -> 포워딩할 경로
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dp = request.getRequestDispatcher(viewName);
        dp.forward(request, response);


    }


}