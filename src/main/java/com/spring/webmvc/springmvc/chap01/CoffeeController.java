package com.spring.webmvc.springmvc.chap01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class CoffeeController {

    /*
        1. 주문서 페이지
            1.주문서
            2.주문목록
            3.가격
            4. summit 버튼?
            select가 key값 -> americano가 벨류값
            <select id="menu-sel" name="menu">
                        <option value="americano">아메리카노</option>

            가격정보도 파라미터로 같이 보내야함 -> input태그 hidden
            // html 6강 hidden : 보이지 않지만 서버로 전달할 내용
        
        2. 주문하기 버튼
     */

    @RequestMapping("/coffee/form")
    public String order(){
        log.info("/coffee/form GET REQUEST");
        // 커피콩 요청
        return "chap01/coffee-form";
    }

    // 커피주문요청 - controller view 사이에 전송 모델

    // 커피 주문 요청
    @RequestMapping("/coffee/result")
    public String result(@ModelAttribute("menu") String menu,
                         @ModelAttribute("price") int price,
                         Model model) {
        log.info("/coffee/result POST! - [" + menu + ", " + price + "]");

        model.addAttribute("menu", menu);
        model.addAttribute("p", price);

        return "chap01/coffee-result";
    }

}
