package com.spring.webmvc.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("work요청이 들어옴!");

        // 요청정보 응답정보가 다르게 나간다
        
        // 1. redirect : 재요청(work 요청 -> result 요청 )
        // 주소창 변동 O + 새로운 데이터를 들고감
//        resp.sendRedirect("/jsp/result.jsp");
        
        // 2. forward : 강제이동
        // 주소창 변동 X
        // 웹서버 안에서 해결됨 + 데이터를 들고감
        // http://localhost:8184/work?food=먹을거
        // 주소로 타고 리소스 가져오는거 차단  webapp -> WEB-INF
        // http://localhost:8184/WEB-INF/blah.jap
        // 타고 못들어온다 -> 다른게 열어주기?
        // ex>게시글 상세조회
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp");
        rd.forward(req, resp);

    }
}
