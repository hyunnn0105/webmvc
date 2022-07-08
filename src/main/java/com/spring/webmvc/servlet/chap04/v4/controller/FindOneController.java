package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

public class FindOneController implements ControllerV4{

    private MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        String user = paramMap.get("userNum");
        int userNum = Integer.parseInt(user);
        Member member = repository.findOne(userNum);
        model.addAttribute("m", member);
        return "detail";
    }
}
