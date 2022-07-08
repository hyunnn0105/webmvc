package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Controller = 요청처리
@Controller
// @RequestMapping("/model") -> 공통 uri처리 /model 생략가능
public class ModelController {

    /*
        private static class ModelURL {
        public static final String HOBBIES = "/hobbies";
        public static final String HOBBIES2 = "/hobbies2";
        public static final String FORM = "/form";
        public static final String CHECK = "/age-check";
    }
    @RequestMapping(ModelURL.HOBBIES) <- 이렇게 사용하기!
    => 유지보수 쉽고 편하게!

     */


    // ======= JSP 파일로 포워딩할때 데이터 전달하기
    // === 1. model 객체 사용하기
    @RequestMapping("/model/hobbies")
    public String hobbies(Model model){

        List<String> hList = new ArrayList<>();
        hList.add("산책");
        hList.add("뛰어놀기");
        hList.add("밥먹기");
        hList.add("낮잠자기");

        model.addAttribute("name", "멍멍이");
        model.addAttribute("hobbies", hList);
        // hobbies.jsp가 chap01 아래에 있어야함
        return "chap01/hobbies";
    }
    
    // === modelAndView 사용하기 리턴타입 모델앤뷰 == frontControllerV3
    @RequestMapping("/model/hobbies2")
    public ModelAndView hobbies2(){

        List<String> hList = new ArrayList<>();
        hList.add("영봐보기");
        hList.add("맛집가기");
        hList.add("카페가기");

        // modelandview 객체생겅
        ModelAndView mv = new ModelAndView("chap01/hobbies2");
        mv.addObject("name","짹짹이");
        mv.addObject("hobbies",hList);

        return mv;
    }

    //age-form 띄우기
    @RequestMapping("model/form")
    public String form() {
        return "chap01/age-form";
    }

    // age데이터 처리
    @RequestMapping("/model/age-check")
    public String check(int age, Model model) {
        // 나이로 출생년도 구해주기 (한국나이)
        int birthYear = LocalDate.now().getYear() - age + 1;

        model.addAttribute("bYear", birthYear);
        model.addAttribute("age", age);

        return "chap01/age-result";
    }


}
