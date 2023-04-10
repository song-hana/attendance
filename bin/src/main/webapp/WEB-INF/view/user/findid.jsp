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
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js'></script>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src='<c:url value="/res/common.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/res/common.css"/>'/>
<title></title>
<script>
    $(() => {
        input_form_header()
        
        $('#showID').click(e => {
        	e.preventDefault()
        	$('#modalMsg').empty()
        	findId($('#name').val(), $('#ph').val())
            $('#modal').modal('show')
        })
    })
    
    function findId(name, ph) {
    	$.ajax({
    		url: 'findId',
    		type: 'post',
    		data: ({
    			empName: name,
    			empPh: ph
    		}),
    		success: id => {
    			$('#modalMsg').text('ID는 ' + id + ' 입니다.')
    		}
    	})
    }
</script>
<style>
    #showID {
        margin-top: 3rem;
    }
    
    input[type='submit'] {
        position: relative;
        width: 60%;
        left: 20%;
    }
</style>
</head>
<body>
<div class='container'>
    <div class='row title'></div>
    <div class='text'><b>아이디 찾기</b></div>
    <div class='row mt-3'>
        <form class='form_box'>
            <input type='text' id='name' class='form-control' placeholder='이름'/><br>
            <input type='text' id='ph' class='form-control' placeholder="전화번호('-'제외)"/><br>
            <input type='submit' id='showID' class='btn btn-blue text-center' value='아이디 찾기'/><br>
        </form>
    </div>
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
                <button type='button' class='btn btn-blue' id='modalLoginBtn' onclick="location.href='login'">로그인</button>
                <button type='button' class='btn btn-lightgray' id='modalPWBtn' onclick="location.href='findPw'">비밀번호 찾기</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>