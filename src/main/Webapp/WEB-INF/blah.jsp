<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>

    <h1>blah.jsp 입니다~~ 이 파일은 서버에서만 접근 가능하다!</h1>
    
    
        서버에서 온 메시지 : ${msg}
        <br>
        서버에서 온 메시지 : ${number * 3}
        <br>
        서버에서 온 리스트 : ${hobbys}
        <br>

        <!-- jstl을 이용한 반곡문 : 자바코드를 태그화 시킴 -->
        <!-- iteration -->
        <c:forEach var = "h" items="${hobbys}">
            # 취미 : ${h} <br>
        </c:forEach>

        <!-- fori like 게시판 페이지-->
        <c:forEach var ="i" begin="1" end="10" step="1">
            ${i}!!
        </c:forEach>

        <c:if test="${number == 100}">
           서버에서 온 숫자는 100과 동일합니다
        </c:if>

        <!-- 다중 if -->
        <c:choose>
            <c:when test="${hobbys.size() > 0}">
                취미있음
            </c:when>
            <c:when test="$">
                취미있음
            </c:when>
            <c:otherwise>
                취미가 없습니다~~~
            </c:otherwise>

        </c:choose>


    </p>
</body>
</html>