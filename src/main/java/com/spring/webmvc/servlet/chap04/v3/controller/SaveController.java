package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;
/*
public class SaveController implements ControllerV3 {

    private final MemberRepository repository
            = MemoryMemberRepo.getInstance();


    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        String account = paramMap.get("account");
        String password = paramMap.get("password");
        String userName = paramMap.get("userName");

        Member member = new Member(account, password, userName);
        repository.save(member);

//        response.sendRedirect("/");
        
        //  forwading은 파일명만 작성
        // 리다이렉트는 경로 지정
        return new ModelAndView("redirect:/");
    }
}


 */