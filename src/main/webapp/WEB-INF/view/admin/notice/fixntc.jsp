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
<title></title>
<script>
    $(() => {
        input_admin_header()
        input_admin_sidebar()
        input_footer()

        $('#fixNOBtn').click(() => {
            $('#modalMsg').empty()
            $('#modalMsg').append(`<p>이 페이지를 벗어나면 수정 중이던 글이 취소됩니다.<br>
                            저장을 하실 경우 취소 버튼을 누르고 저장을 해주세요.<br>
                            이미 저장한 경우에는 확인 버튼을 눌러주세요.</p>`)
            $('#modal').modal('show')
        })
    })
</script>
<style>
    #noticeTitle {
        width: 100%;
        padding: 5px;
        border: .1rem solid;
        border-radius: .2rem;
    }

    textarea {
        width: 100%;
        height: 15rem;
        padding: 10px;
        border: .1rem solid;
        border-radius: .2rem;
    }   
</style>
</head>
<body>
<div class='container'>
    <div class='row header'></div>
    <div class='row mt-5'>
        <div class='col-2 snb'></div>
        <div class='col'>
            <div class='row mt-4'>
                <div class='col'>
                    <h2><b>공지사항</b></h2>
                </div>
            </div>
            <div class='row pt-3'>
                <div class='col'>
                    <p>하나웍스 서비스 안내와 공지에 대한 소식을 전해드립니다.</p>
                    <hr>
                    <b>공지수정</b>
                </div>
            </div>
            <div class='row pt-2'>
                <div class='col'>
                    <h4>제목</h4>
                    <input type='text' id='noticeTitle' value='개인정보처리방침 개정 안내 (2023.01.05 개정)'>
                    <h4 class='pt-3'>내용</h4>
                    <textarea>
1.변경 내용
    - 개인 정보 처리 방침
      법령 삭제에 따른 법령 변경
      개인 정보 보호책임자 변경
    
2.약관 개정 고지일
    - 2023년 01월 02일

3.개정 약관 적용 일자</textarea>
                </div>
            </div>
            <div class='row'>
                <div class='col d-flex justify-content-end'>
                    <button type='button' class='btn me-3 btn-blue' onclick="window.location.href='07.html'">저장</button>
                    <button type='button' class='btn btn-secondary' id='fixNOBtn'>취소</button>
                </div>
            </div>
        </div>
    </div>
    <div class='footer'></div>
</div>
<div class='modal fade' id='modal'>
    <div class='modal-dialog'>
        <div class='modal-content'>
            <div class='modal-header'>
                <button type='button' class='btn-close' data-bs-dismiss='modal'></button>
            </div>
            <div class='modal-body'>
                <p id='modalMsg'></p>
            </div>
            <div class='modal-footer' id='modalBtn'>
                <button type='button' class='btn m-2 btn-lightgray' id='modalCancelBtn' data-bs-dismiss='modal'>취소</button>
                <button type='button' class='btn btn-blue' id='modalOKBtn' onclick="window.location.href='09.html'">확인</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>