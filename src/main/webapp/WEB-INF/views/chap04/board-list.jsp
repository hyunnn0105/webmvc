<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

<style>
    .table {
        width: 90%;
        margin: 10px auto;
    }

    .box {
        padding: 30px 0px;
    }

    .alert{
        width: 90%;
        margin: 10px auto;
    }
</style>
</head>

<body>

    <!-- navbor -->

    <nav class="navbar bg-light">
        <div class="container-fluid">
          <a class="navbar-brand">Board</a>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
    </nav>

    
    <div class="box"></div>

    <div class="alert alert-dark" role="alert">
      게시판에 자유롭게 글을 등록해보세요
    </div>

    <div class="d-grid gap-1 d-md-flex justify-content-md-end">
        <button class="btn btn-primary me-md-2" type="button" onclick="location.href='/board/write'">글쓰기</button>
    </div>
    <!-- <a class="write-btn" href="/board/write">글쓰기</a> -->


    <table class="table">
      <thead>
        <tr>
          <th scope="col">글번호</th>
          <th scope="col">작성자</th>
          <th scope="col">제목</th>
          <th scope="col">등록일</th>
          <th scope="col">조회수</th>
          <th scope="col"> </th>
        </tr>
      </thead>
      <tbody>

          <c:forEach var="b" items="${board}">
            <tr>
            <th scope="row">${b.boardNo}</th>
                <!-- <td></td> -->
                    <td>${b.writer}</td>
                        <td><a class="btn-con" href="/board/content?boardNo=${b.boardNo}">${b.title}</a></td>
                            <td>${b.regDate}</td>
                            <td>${b.viewCnt}</td>
                                <td><a class="btn-con" href="/board/content?boardNo=${b.boardNo}">수정</a></td>
            </tr>
          </c:forEach>



      </tbody>
    </table>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

</body>
</html>