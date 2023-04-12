<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js'></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src='<c:url value="/res/common.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/res/common.css"/>'>
<title>비밀번호 변경</title>
<script>
	const employeeNo = ${sessionScope.empNo}
	let passwordCheck = false;

    $(() => {
        input_user_header()
        btn_click()
        show_logout()
        console.log(employeeNo)

        $('#fixEmployeePwBtn').click(function() {
			if(employeeNo) {
				
			const employeePw = $('#password').val()
				
			 $.ajax({
			     url: 'fixpw/check',
			     type: 'get',
			     data: {
			    	 employeeNo: employeeNo,
			    	 employeePw: employeePw
			   	 },
			     success: function(result) {
			         console.log(result)
			         if (result == '1') {
			        	 passwordCheck = true
			         	
			         	$('#pwErrMsg').text('비밀번호가 일치합니다.').css('color', 'green')
			         } else {
			        	 passwordCheck = false
			         	checkIdVal = $('#companyId').val()
			         	$('#pwErrMsg').text('비밀번호가 일치하지 않습니다.').css('color', 'red')
			         }
			     }
			 })
			 
			 let newPassword = $('#newPassword')
			
				if(6 <= newPassword.length && newPassword.length <= 15) {
					
				} else {
					$('#newPwErrMsg').text('숫자,문자 포함 6자 이상 15자 이하로 입력하세요.').css('color', 'red')
				}
			} else {
				$('#pwErrMsg').text('비밀번호를 입력하세요.').css('color', 'red')
			}
			
			
			
		})
		$('#modalMsg').text('변경되었습니다.')        
        $('#myModal').modal('show')
    })
</script>
<style>
    #fixpassword{
        margin-top: 5rem;
    }
</style>
</head>
<body>
<div class='container'>
    <div class='row header'></div>
    <div class='row mt-4'>
        <div class='col text-center'>
            <h3><b>비밀번호 변경</b></h3>
        </div>
    </div>
    <div class='row pt-4'>
        <div class='col'>
            <form class='form_box'>
                <label for='password'><b>현재 비밀번호</b></label>
                <input type='password' class='form-control' id='password' placeholder='숫자, 문자 포함 6자 이상 15자 이하로 입력하세요.'>
				<span id='pwErrMsg'></span>
				<br>    			
                <label for='new password'><b>새 비밀번호</b></label>
                <input type='password' class='form-control' id='newpassword' placeholder='숫자, 문자 포함 6자 이상 15자 이하로 입력하세요.'>
                <span id='newPwErrMsg'></span>
                <br>
                <label for='password_confirm'><b>새 비밀번호 확인</b></label>
                <input type='password' class='form-control' id='password_confirm' placeholder='비밀번호를 다시 입력하세요.'>
    			<span id='newPwCheckErrMsg'></span>
    			<br><br>
    
                <button type='button' id='fixEmployeePwBtn' class='btn btn-blue text-center'>변경완료</button><br>
            </form>
    
        </div>
    </div>
    <div class='navigation'></div>
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
                <button type='button' class='btn btn-blue' id='modalOKBtn'>확인</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>