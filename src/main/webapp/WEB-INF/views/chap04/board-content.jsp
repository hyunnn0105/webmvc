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
    <section class="detail">
        <label>
            # ${no.boardNo} 번 게시물
        </label>
        <label>
            # 작성자 ${no.writer}
        </label>
        <label>
            # 글제목 ${no.title}
        </label>
        <label>
            # 내용 ${no.content}
        </label>
        <a class="modi-btn" href="/board/modify?boardNo=${no.boardNo}">수정</a>
        <a href="/board/delete?boardNo=${no.boardNo}">삭제</a>
        <a class="list-btn" href="/board/list">목록</a>
    </section>

</body>
</html>