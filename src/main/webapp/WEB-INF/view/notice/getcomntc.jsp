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
<title>user 사내 공지사항 조회</title>
<script>
    $(() => {
        input_user_header()
        btn_click()
        show_logout()
    })
    
    /*
    function getCompanyNotice() {
    	$.ajax({
    		url: 'getcomntc/get',
    		dataType: 'json',
    		data : {
    			companyNoticeNo : companyNoticeNo
    		},
    		success: companyNoticeDetail
    	})
    	
    */
    }
</script>
<style>
    .table {
        font-size: .8rem;
        border: .1rem solid;
        height: 20rem;
    }
    #decimal {
        list-style-type: decimal;
    }
    #decimal li {
        margin-bottom: 1rem;
        margin-top: 1rem;
    }

    .liNone {
        list-style-type: none;
    }

    th {
        font-size: 1rem;
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
    <div class='row pt-5 mb-5'>
        <div class='col'>
            <table class='table' id='companyNoticeDetail'>

                <caption class="text-end"><button type='button' class='btn btn-secondary' onclick="window.location.href='comntclist'">목록</button></caption>
            </table>
        </div>
    </div>
    <div class='navigation'></div>
</div>
</body>
</html>