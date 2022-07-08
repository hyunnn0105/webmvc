package com.spring.webmvc.servlet.chap04;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//공ㅇ용클래스 view 생성
//뷰를 포워딩하는 기능
@Setter @Getter
public class View {

    private String viewName; // 포워딩할 뷰의 경로
    private String prefix; // 접두사(ex: /WEB-INF/views )
    private String suffix; // 접미사(ex: .jsp )
    private boolean redirect; // 리다이렉트인지 확인


    // 경로 간단하게 지정 - 포워드/리다이렉트 구분하기
    public View(String viewName) {
        this.prefix = "/WEB-INF/views/";
        this.suffix = ".jsp";
        if (!isRedirect(viewName)){
            this.viewName = prefix+viewName+suffix;
        } else {
            // 리다이렉트라면?? -> 구분하려고 쓴 redirect 지워주기 => 경로만 남기기
            this.viewName = viewName.substring(viewName.indexOf(":")+1);
        }

    }

    //포워딩 기능
    // 준것 -> 포워딩할 경로
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!this.redirect){
            RequestDispatcher dp = request.getRequestDispatcher(viewName);
            dp.forward(request, response);
        } else {
            //redirect 기능
            response.sendRedirect(viewName);
        }
    }
    
    // 현재 뷰네임이 리다이렉트인지 확인
    private boolean isRedirect(String viewName){
        /*
        // contains() -> ()안에 있는게 포함되어 있는지 확인함
        boolean flag = viewName.contains("redirect:");
        if (flag) {
            this.redirect = true;
            return true;
        } else {
            this.redirect = false;
            return false;
        }

         */
        return this.redirect = viewName.contains("redirect:");
    }


}
