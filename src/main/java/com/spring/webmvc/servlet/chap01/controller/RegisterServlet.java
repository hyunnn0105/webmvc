package com.spring.webmvc.chap01.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// /register-form 요청을 처리할 서블릿 클래스
// 회원 가입 양식을 보여주고~~ 회원
@WebServlet("/register-form")
public class RegisterServlet extends HttpServlet {
    // 1. 상속받기
    // 2. 웹서블릿
    // 회원가입 폼을 그려야함 (SSR)
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 회원가입 폼을 그려야함 (SSR)
        PrintWriter w = resp.getWriter();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        w.write("<!DOCTYPE html>\n");
        w.write("<html lang='ko'>\n");
        w.write("<head>\n");
//        w.write("<meta charset='EUC-KR'>\n");
        w.write("<title>회원가입 양식</title>\n");
        w.write("<style>label { display: block; }</style>\n");

        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<form action='/reg-process' method='post'>\n"); // /reg-process 
        // form에 연결하는 주소? 위치 넣어주기 
        w.write("<label># accout: <input type='text' name='account'></label>\n");
        w.write("<label># password: <input type='password' name='password'></label>\n");
        w.write("<label># username: <input type='text' name='userName'></label>\n");
        w.write("<label><button type='submit'>register</button></label>\n");



        w.write("</form>\n");
        w.write("</body>\n");
        w.write("</html>\n");

    }

}


