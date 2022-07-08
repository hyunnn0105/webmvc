package com.spring.webmvc.servlet.chap04.v1.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
    /mvc/v1/join - 회원가입 폼 요청 -> FrontController 연결
    /mvc/v1/save - 회원저장 폼 요청 -> SaveController 연결
    /mvc/v1/show - 회원 조회 폼 요청 -> ShowController 연결

 */


@WebServlet("/mvc/v1/*")
// '/*'모든 요청을 다 처리한다 -> (/mvc/v1으로 시작)앞에 제약사항 두는 것도 가능!
public class FrontController extends HttpServlet {

    private final Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontController(){
        // 이런거오면 key를 가진 적당한 컨트롤러 시킴
        controllerMap.put("/mvc/v1/join" , new FormController());
        controllerMap.put("/mvc/v1/save" , new SaveController());
        controllerMap.put("/mvc/v1/show" , new ShowController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String uri = req.getRequestURI();
        System.out.println("fornt-controller 요청이 들어옴~~~" + uri);

        // 받아둔 uri로 controller
        // 컨트롤러맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ControllerV1 controller = controllerMap.get(uri);

        // uri가 이상한 주소 받을거 대비!
        if (controller == null){
            // 보여줄게 없을때 슝 -> 404 not found
            // 에러페이지 따로 제작가능
            resp.setStatus(404);
            return;
        }

        controller.process(req,resp);

    }
}
