<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <h1>mvc버전 전체회원조회</h1>
    <ul>

            <c:forEach var="m" items="${mList}">
                <li>
                    # 회원번호 ${m.userNum} :
                    , # id : ${m.account}
                    , <a href="/mvc/v4/member?userNum=${m.userNum}">
                        # name : ${m.userName}
                    </a>
                &nbsp;&nbsp;&nbsp;
                <a id="rm-btn" href="/mvc/v4/remove?userNum=${m.userNum}">[delete]</a>
                    
                </li>
            </c:forEach>

    </ul>
        <!-- 뷰에서 새로운 시작을 할 수도 있음 -->
        
        <a href="/mvc/join">새로운 회원 가입하기</a>
        
        <script>

            const $rmBtn = document.querySelector('#rm-btn');
                    $rmBtn.addEventListener('click', e => {
                        if (!confirm('진짜루 삭제???')) {
                            e.preventDefault(); // 링크 이동 중지
                            // 삭제 취소
                            return;
                        }
                    });


        </script>

</body>
</html>