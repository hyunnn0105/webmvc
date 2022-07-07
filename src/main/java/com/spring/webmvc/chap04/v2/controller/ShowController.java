package com.spring.webmvc.chap04.v2.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.chap04.v1.controller.ControllerV1;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowController implements ControllerV2 {

    private final MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = repository.findAll();
        System.out.println(members);
        // model 역할
        request.setAttribute("mList", members); // request 객체에 데이터를 넣음

        return new View("/WEB-INF/views/members.jsp");

    }
}
