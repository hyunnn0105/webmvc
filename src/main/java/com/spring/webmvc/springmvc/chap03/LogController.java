package com.spring.webmvc.springmvc.chap03;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class LogController {

    @RequestMapping("/log/test")
    // value = "/log/test" , method = RequestMethod.GET
    @ResponseBody // 클라이언트에게 직접 데이터 전달 not html
    public String logTest(){

        // 로그의 레벨을 지정할 수 없다.
        System.out.println("log!!");

        /*
            trace: 로컬 피씨에서 테스트
            debug: 개발 서버에서 찍는 로그
            info:  운영 서버에서 찍는 로그
            warn:  경고사항에 대한 로그
            error: 에러 상황에 대한 로그
         */
        log.trace(" trace log!!");
        log.debug(" debug log!!");
        log.info(" info log!!");
        log.warn(" warn log!!");
        log.error(" error log!!");

        log.trace("메롱");
        log.debug(" parameter ");

        try {
            log.info("info log");
        } catch (Exception e) {
            log.error(" 심각해!!");
//            throw new Exception();
        }

        return "hello";

    }

    @GetMapping("/req/bye")
    @ResponseBody
    public String bye(){
        log.info("req/bye");
        return "bye!!1";
    }

    // url
    @GetMapping("/member/{un}")
    @ResponseBody
    // 동일하면 생략가능
    // 주소창으로 접근하면 다 GET이다!!
    public String member(@PathVariable("un") String userName){
        return " i am " + userName;
    }

}
