package com.spring.webmvc.servlet.chap04.v5.controller;

import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
    컨트롤러 하나 생성
    매서드로 하위 컨트롤러 생성 + like @Bean 생성

 */


@RequestMapping("/mvc/v5/*")
// @Controller // front-controller에 알아서 넣어줌
public class Membercontroller {
    private final MemberRepository repository;

   // @Autowired
    public Membercontroller(MemberRepository repository) {
        this.repository = repository;
    }

    // 회원 가입 양식 화면 요청 처리
    @RequestMapping("/join")
    public String join(){
        return "reg_form";
    }
    // 회원 가입 실제 저장 처리 요청
    @RequestMapping("/save")
    public String save(Member member){
        repository.save(member);
        return "redirect:/";
    }
    // 회원 목록 조회요청
    @RequestMapping("/show")
    public String show(Model model){
        List<Member> members = repository.findAll();
        model.addAttribute("mList", members);
        return "members";
    }
}
