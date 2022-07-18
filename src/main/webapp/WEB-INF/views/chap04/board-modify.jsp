<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
    <section class="modify">
        
        <h1>글 수정</h1>

        <form action="/board/modify" method="post">
            <label>
                # ${b.boardNo} 번 게시물
            </label>

            <input type="hidden" name="boardNo" value="${b.boardNo}">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">작성자
                <input type="text" class="form-control" id="exampleFormControlInput1" name="writer" value="${b.boardNo}">
                </label>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">제목
                <input type="text" class="form-control" id="exampleFormControlInput1" name="title" value="${b.title}">
                </label>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">글작성
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content">${b.content}</textarea>
                </label>
            </div>
            
            <!-- <label> 
                # ${b.boardNo} 번 게시물
            </label>
            <label>
                <input type="hidden" name="boardNo" value="${b.boardNo}">
                
                # 작성자  <input type="text" value="${b.writer}" name="writer">
            </label>
            <label>
                # 글제목 <input type="text" value="${b.title}" name="title">
            </label>
            <label>
                # 내용 <input type="text" value="${b.content}" name="content" >
            </label>
            -->
            <label>
                <button type="submit">수정</button>
            </label>
        </form>
            <a class="list-btn" href="/board/list">목록</a>

    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    
</body>
</html>