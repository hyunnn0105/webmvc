package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;
/*
public class ShowController implements ControllerV3 {

    private final MemberRepository repository
            = MemoryMemberRepo.getInstance();


    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        List<Member> members = repository.findAll();
        System.out.println(members);
        // model 역할 -> modelandview에게 맡겨야함
        // 파일명만 보내면 열어주기
        ModelAndView mv = new ModelAndView("members");

        // request.setAttribute("mList", members); -> front controller가 대신 쳐줌
        // 여러번 할 수도 있음
        mv.addAttribute("mList", members);
        return mv;
    }
}

 */
