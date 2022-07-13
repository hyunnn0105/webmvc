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
    <h1>로그인하세요</h1>
    <!-- action으로 값 넙기기...  -->
    <form action="/hw/s-login-check" method="post">
        <label>
            # id : <input type="text" name="id">
            # password : <input type="password" name="pw">
        </label>
        <label>
            <button type="submit">로그인</button>
        </label>
    </form>
</body>
</html>