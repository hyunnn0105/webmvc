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
    form {
        width: 90%;
    }
    
    .form-control{
        width: 100%;
        margin: 10px auto;
    }
    
    input{
        width: 100%;
        margin-bottom: 20px;
    }

    textarea {
        width: 100%;
        margin-bottom: 20px;
    }
</style>
    


<body>

    <section class="board">
        <h1>글 작성하기</h1>
        
        <form action="/board/write" method="post">

            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">작성자
                <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="10자이내로 입력하세요" name="writer">
                </label>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">제목
                <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="제목을 입력하세요" name="title">
                </label>
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">글작성
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"></textarea>
                </label>
            </div>


            <label>
                <!-- <button type="submit">글쓰기</button> -->
                <div class="d-grid gap-1 d-md-flex justify-content-md-end">
                  <button class="btn btn-primary me-md-1" type="submit">등록</button>
                </div>

                <div class="d-grid gap-1 d-md-flex justify-content-md-end">
                    <button class="btn btn-primary me-md-1" type="button" onclick="location.href='/board/list'">HOME</button>
                </div>
            </label>
            
        </form>
        
    </section>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>


