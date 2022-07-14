package com.spring.webmvc.springmvc.chap03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RequestContoller{
    @RequestMapping(value = "/log/test" , method = RequestMethod.GET)
    public String hi() {
        return "1111";
    }


}
