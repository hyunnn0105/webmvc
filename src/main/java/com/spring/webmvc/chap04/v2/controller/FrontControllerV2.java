package com.spring.webmvc.chap04.v2.controller;

import com.spring.webmvc.chap04.View;

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


@WebServlet("/mvc/v2/*")
// '/*'모든 요청을 다 처리한다 -> (/mvc/v1으로 시작)앞에 제약사항 두는 것도 가능!
public class FrontControllerV2 extends HttpServlet {

    private final Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerV2(){
        // 이런거오면 key를 가진 적당한 컨트롤러 시킴
        controllerMap.put("/mvc/v2/join" , new FormController());
        controllerMap.put("/mvc/v2/save" , new SaveController());
        controllerMap.put("/mvc/v2/show" , new ShowController());
    }


    // 서블릿에 대한 종속성~~~??
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String uri = req.getRequestURI();
        System.out.println("fornt-controller 요청이 들어옴~~~" + uri);

        // 받아둔 uri로 controller
        // 컨트롤러맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ControllerV2 controller = controllerMap.get(uri);

        // uri가 이상한 주소 받을거 대비!
        if (controller == null){
            // 보여줄게 없을때 슝 -> 404 not found
            // 에러페이지 따로 제작가능
            resp.setStatus(404);
            return;
        }

        View view = controller.process(req, resp);
        if (view != null) view.render(req, resp);

    }
}
