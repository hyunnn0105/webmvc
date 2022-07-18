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
<style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    
    /* Set black background color, white text and some padding */
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }

    .col-sm-9 {
      margin: 10px auto;
    }

    .btns{
      padding: 10px auto;
    }
  </style>
<body>
    <section class="detail">
        <div class="col-sm-9">
            <h4><small> <label> ${no.boardNo}번 게시글 보기</label> </small></h4>
            <hr>
            <h2><label>${no.title}</label></h2>
            <h5><span class="glyphicon glyphicon-time"></span> Post by ${no.writer}.</h5>
            <p><label>${no.content}</label></p>
            <br><br>
            
      
        </div>
        <div class="btns">
            <button type="button" class="btn btn-outline-primary" onclick="location.href='/board/modify?boardNo=${no.boardNo}'">Modify</button>
            <button type="button" class="btn btn-outline-danger" onclick="location.href='/board/delete?boardNo=${no.boardNo}'">Delete</button>
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='/board/list'">List</button>
        </div>

    </section>

   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
