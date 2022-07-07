package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.chap04.v2.controller.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/*
    /mvc/v1/join - 회원가입 폼 요청 -> FrontController 연결
    /mvc/v1/save - 회원저장 폼 요청 -> SaveController 연결
    /mvc/v1/show - 회원 조회 폼 요청 -> ShowController 연결

 */


@WebServlet("/mvc/v3/*")
// '/*'모든 요청을 다 처리한다 -> (/mvc/v1으로 시작)앞에 제약사항 두는 것도 가능!
public class FrontControllerV3 extends HttpServlet {

    private final Map<String, ControllerV3> controllerMap
            = new HashMap<>();

    public FrontControllerV3() {
//        controllerMap.put("/mvc/v3/join", new FormController());
//        controllerMap.put("/mvc/v3/save", new SaveController());
//        controllerMap.put("/mvc/v3/show", new ShowController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        // 현재 들어온 요청 URI를 반환
        String uri = req.getRequestURI();

        // 컨트롤러맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ControllerV3 controller = controllerMap.get(uri);

        if (controller == null) {
            resp.setStatus(404); // 404 : page not found
            return;
        }


        // 요청 파라미터(query parameter)를 전부 읽어서 하위 컨트롤러들에게 보내줌
        // key: 파라미터의 key, value: 파라미터의 value
        Map<String, String> paramMap = createParamMap(req);


        View view = controller.process(paramMap);
        if (view != null) view.render(req, resp);

    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);
            paramMap.put(key, value);
        }
        return paramMap;
    }

}
