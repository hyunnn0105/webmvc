package com.spring.webmvc.chap04.v2.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.chap04.v1.controller.ControllerV1;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveController implements ControllerV2 {

    private final MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");

        Member member = new Member(account, password, userName);
        repository.save(member);

        response.sendRedirect("/");
        
        // 포워딩  안함
        return null;
    }


}
