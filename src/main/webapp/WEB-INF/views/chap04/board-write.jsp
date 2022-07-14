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

    <section class="board">
        <h1>글 작성하기</h1>
        
        <form action="/board/write" method="post">
            <label>
                # 작성자 <input type="text" name="writer">
            </label>
            <label>
                # 제목 <input type="text" name="title">
            </label>
            <label>
                # 내용 <input type="text" name="content">
            </label>
            <label>
                <button type="submit">글쓰기</button>
                <a href="/board/list">홈화면으로 돌아가기</a>
            </label>
            
        </form>
        
    </section>

</body>
</html>