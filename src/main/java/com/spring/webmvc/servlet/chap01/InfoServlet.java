package com.spring.webmvc.chap01;
/*
    # 서블릿 : http 요청과 응답 데이터를 쉽게 처리할 수 있도록 도와주는 자바의 API
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    public InfoServlet(){
        System.out.println("\n\n\n\nInfoServlet constructor call!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n\ninfo 요청이 들어왔습니다.");
        // 요청정보 받기
        Double height = Double.parseDouble(req.getParameter("height"));
        Double weight = Double.parseDouble(req.getParameter("weight"));

        // 응답정보 생성하기
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<html>");
        w.write("<body>");
        double bmi = calcBMI(height, weight);
        w.write(" <h1>당신의 체질량 지수는 " + bmi + "이군요?</h1>");

        if (bmi > 25.0){
            w.write("<h2>과체중입니다.</h2>");
        } else if (bmi < 18.5) {
            w.write("<h2>저체중입니다.</h2>");
        } else {
            w.write("<h2>정상체중입니다.</h2>");
        }
        w.write("<body>");
        w.write("<html>");

        // http://localhost:8181/info?hobby=exercise
    }

    private void destory(){
        System.out.println("\n\n\nservlet difappear?\n");
    }

    private double calcBMI(double cm, double kg){
        double m = cm/100;
        double bmi = kg / (m*m);
        return bmi;
    }


}
