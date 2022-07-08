package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.chap04.v4.controller.ControllerV4;

import java.util.Map;

public class FormController implements ControllerV4 {

    //request 사용XX
    @Override
    public String process(Map<String, String> paramMap, Model model) {
        return "reg_form";
    }
}
