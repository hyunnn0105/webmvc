package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller // 스프링 컨테이너에 빈 등록
// 스프링의 HandlerMapping이 찾아서 DispatcherServlet에 연결
public class BasicController {
    // 클라이언트 요청 받기
    @RequestMapping("/spring/about") // 요청 uri 적용
    public String about(){
        System.out.println("about 요청이 들어옴");
        
        // /WEB-INF/views/about.jsp 포워딩
        return "about"; //jsp 파일 포워딩, 리다이렉트
    }

    // 클라이언트 요청 받기
    @RequestMapping("/spring/hello") // 요청 uri 적용
    public String hello(){
        System.out.println("hello 요청이 들어옴");

        // /mvc/join로 재요청(redirect)
        return "redirect:/mvc/join"; //jsp 파일 포워딩, 리다이렉트
    }
    
    // ============== 요청 파라미터 받기 (query parameter) ======================
    
    // 2번이랑 3번 방법 사용 많이함
    
    // === 1. HttpServletRequest 사용하기
    // ex> /spring/person?name=kim&age=30
    @RequestMapping("/spring/person")
    public String person(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "";
    }
    
    // @RequestParam 사용하기 -> 지역변수랑 이름이 동일(충돌)할 때 사용***
    // ex) /spring/major?stu=kim&major=budiness&grade=3
    @RequestMapping("/spring/major")
    public String major(
            //          (파라미터명) (타입)(변수)
            @RequestParam("stu") String aaa
            , @RequestParam("major") String major
            , @RequestParam("grade") int grade // int로 잡으면 알아서 String 변환
    ){
        System.out.println("aaa = " + aaa);
        System.out.println("major = " + major);
        System.out.println("grade = " + grade);
        return "";
    }

    // /spring/major2?stu=ko&major=budiness&grade=4
    // 요청 파라미터 키값과 메서드 매개변수 이름이 같으면
    // @RequestParam 생략가능
    @RequestMapping("/spring/major2")
    public String major2(
            //          (파라미터명) (타입)(변수)
            String stu
            , String major
            , int grade // int로 잡으면 알아서 String 변환
    ){
        System.out.println("stu = " + stu);
        System.out.println("major = " + major);
        System.out.println("grade = " + grade);
        return "";
    }

    // == 3. 커맨드 객체 이용하기
    // ex> /spring/order?oNum=22&goods=dress&amount=3&price=10000 ... 넘어오는 값이 많을때
    @RequestMapping("/spring/order")
    // class type 넣기
    //but 쿼리 파라미터의 키 값과 커멘드객체의 필드명이 같아야 인식함!!! 대/소문자까지
    // 반드시 @Setter @Getter가 있어야함
    public String order(Order order){
        System.out.println(order);
        return "";
    }

}
