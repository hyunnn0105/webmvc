package com.spring.webmvc.servlet.controller;

import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc/show")
public class ShowServlet extends HttpServlet {
    private final MemberRepository repository = MemoryMemberRepo.getInstance();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = repository.findAll();
        System.out.println(members);
        // list console에서 []
        // [Member(userNum=1, account=sfaw, password=123, userName=fgh), Member(userNum=2, account=wefw, password=werw, userName=ghgh)]

        // jsp에 members 데이터 넘기기
        // model : controller와 View 사이의 데이터(리스트)를 운반하는 수단 객체
        // - 여기서 모델의 역할은 Request 객체가 담당
        req.setAttribute("mList", members); // request 객체에 데이터를 넣음
        

        String viewName = "/WEB-INF/views/members.jsp";
        RequestDispatcher dp = req.getRequestDispatcher(viewName);
        dp.forward(req, resp);

        // jsp에서 members 출력
    }
}
