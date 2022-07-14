<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<style>
    li{
        color: blue;
    }
</style>
</head>
<body>


    <ul>
        <c:forEach var="b" items="${board}">
            <li>
                게시글 번호 : ${b.boardNo}
                작성자 : ${b.writer}
                제목 : ${b.title}
                <a href="/board/content?boardNo=${b.boardNo}">수정</a>
            </li>
        </c:forEach>

        <a class="write-btn" href="/board/write">글쓰기</a>
    </ul>
</body>
</html>