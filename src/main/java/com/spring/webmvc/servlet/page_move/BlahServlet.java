package com.spring.webmvc.servlet.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/blah")
public class BlahServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/WEB-INF/blah.jsp"); -> 클라이언트에 도착해서 불가
        
        // 모델에 데이터 담기 key -> "msg" / 오브젝트 타입이라 모두 가능
        // Arrays.asList("수영", "독서", "수면") return type List
        req.setAttribute("msg", "안녕하세요");
        req.setAttribute("number", 100);
        req.setAttribute("hobbys", Arrays.asList("수영", "독서", "수면"));
        
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/blah.jsp");
        rd.forward(req, resp);
        // 서블릿을 통해 우회해서 접근하기
            // 1.
            // 2. 파라미터 조작 막기

    }
}
