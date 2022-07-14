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
    <section class="modify">
        <form action="/board/modify" method="post">
            <label>
                # ${b.boardNo} 번 게시물
            </label>
            <label>
                # 작성자  <input type="text" value="${b.writer}"> 
            </label>
            <label>
                # 글제목 ${b.title}
            </label>
            <label>
                # 내용 ${b.content}
            </label>
            <label>
                <button type="submit">수정</button>
            </label>
            
            <a class="list-btn" href="/board/list">목록</a>
        </form>
    </section>

</body>
</html>