<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js'></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src='<c:url value="/res/common.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/res/common.css"/>'/>
<title>user 사내 공지사항 목록</title>
<script>
    $(() => {
        input_user_header()
        btn_click()
        show_logout()
    })
</script>
<style>
    table {
        font-size: .8rem;
        border-top: .1rem solid;
    }
    
    table a {
        color: black;
    }

    tr th:first-child {
        width: 14%;
        text-align: center;
    }

    tbody tr td:first-child  {
        text-align: center;
    }
</style>
</head>
<body>
<div class='container'>
    <div class='row header'></div>
    <div class='row mt-5 mb-3'>
        <div class='col text-center'>
            <h1><b>사내 공지사항</b></h1>
        </div>
    </div>
    
    <div class='row pt-4 mt-5'>
        <div class='col'>
            <table class='table table-ellipsis'>
                <thead>
                    <tr>
                        <th>글 번호</th>
                        <th>제목</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>3</td>
                        <td><a href='04.html'>[안내] 연차 안내</a></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><a href='04.html'>[안내] 신년 행사 안내</a></td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td><a href='04.html'>[안내] 2023년도 건강검진 안내</a></td>
                    </tr>
                    <tr><td><p></p></td><td></td><td></td></tr>
                    <tr><td><p></p></td><td></td><td></td></tr>
                    <tr><td><p></p></td><td></td><td></td></tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class='navigation'></div>
</div>
</body>
</html>