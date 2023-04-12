<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js'></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css'/>
<script src='<c:url value="/res/common.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/res/common.css"/>'>
<title>회사 정보 수정</title>
<script>
	let companyId = "${sessionScope.comId}"

	function errMsgClear() {
	    $('#idErrMsg, #pwErrMsg, #pwCheckErrMsg, #nameCheckErrMsg, #regnoErrMsg, #addrErrMsg, #presidentErrMsg, #emailErrMsg, #phErrMsg').empty()
	}

	function isVal(field, errMsgElement, errMsg) {
	    let isGood = false;
	
	    if (!field.val()) {
	        errMsgElement.empty().text(errMsg).css('color', 'red')
	    } else {
	        isGood = true
	    }
	
	    return isGood
	}
	
	let checkId = 0;
	let checkIdVal
	
    $(() => {
        input_form_header()
        listCompany()

        $('.form_box').off('click').on('click', '#fixCompanyBtn', function() {
      		errMsgClear()
        
	        const comPw = $('#comPw')
	        const comPwCheck = $('#comPwCheck')
	        const comName = $('#comName')
	        const comRegno = $('#comRegno')
	        const comPostcode = $('#comPostcode')
	        const comAddr = $('#comAddr')
	        const comDetailAddr = $('#comDetailAddr')
	        const president = $('#president')
	        const inputEmail = $('#inputEmail')
	        const subEmail = $('#subEmail')
	        const comEmail = inputEmail.val() + '@' + subEmail.val()
	        const comPh = $('#comPh')
	
	        const isComPw = isVal(comPw, $('#pwErrMsg'), '비밀번호를 입력하세요.')
	        const isComPwCheck = isVal(comPwCheck, $('#pwCheckErrMsg'), '비밀번호 확인을 입력하세요.')
	        const isComName = isVal(comName, $('#nameCheckErrMsg'), '회사명을 입력하세요.')
	        const isComRegno = isVal(comRegno, $('#regnoErrMsg'), '사업자등록번호를 입력하세요.')
	        const isComAddr = isVal(comAddr, $('#addrErrMsg'), '회사 주소를 입력하세요.')
	        const isPresident = isVal(president, $('#presidentErrMsg'), '대표자명을 입력하세요.')
	        const isInputEmail = isVal(inputEmail, $('#emailErrMsg'), '이메일을 입력하세요.')
	        const isSubEmail = isVal(subEmail, $('#emailErrMsg'), '이메일을 입력하세요.')
	        const isComPh = isVal(comPh, $('#phErrMsg'), '전화번호를 입력하세요.')
			
	        if (isComPw && isComPwCheck && isComName && isComRegno && isComAddr && isPresident && isInputEmail && isSubEmail && isComPh) {
	            let company = {
	                companyId: companyId,
	                comPw: comPw.val(),
	                comName: comName.val(),
	                comRegno: comRegno.val(),
	                comPostcode: comPostcode.val(),
	                comAddr: comAddr.val(),
	                comDetailAddr: comDetailAddr.val(),
	                president: president.val(),
	                comEmail: comEmail,
	                comPh: comPh.val()
	            }
	            
	            if(comPw.val() == comPwCheck.val()) {
		        	$.ajax({
		                url: 'fixinfo/fix',
		                type: 'put',
		                contentType: 'application/json',
		                data: JSON.stringify(company),
		                success: function() {
		                    $('#modalMsg').text('수정완료 되었습니다.')
		                    $('#modalBtn').show()
		                    $('#modal').modal('show')
		                }
		            });
	            } else {
	        		$('#pwCheckErrMsg').text('비밀번호가 일치하지 않습니다.').css('color', 'red')
	            }
	        }
        })
    })
	
	function listCompany() {
	    $.ajax({
	        url: 'fixinfo/get',
	        dataType: 'json',
	        data: { 
	            companyId: companyId
	        },
	        success: companys => {
	            $.each(companys, (i, company) => {
	            	const emailParts = company.comEmail.split('@');
	                const inputEmail = emailParts[0];
	                const subEmail = emailParts[1];
	            	
	                $('#companyId').val(company.companyId)
	                $('#comPw').val(company.comPw)
	                $('#comPwCheck').val(company.comPw)
	                $('#comName').val(company.comName)
	                $('#comRegno').val(company.comRegno)
	                $('#comPostcode').val(company.comPostcode)
	                $('#comAddr').val(company.comAddr)
	                $('#comDetailAddr').val(company.comDetailAddr)
	                $('#president').val(company.president)
	                $('#inputEmail').val(inputEmail)
	                $('#subEmail').val(subEmail)
	                $('#comPh').val(company.comPh)
	            });
	        },
	    });
	}

    
    function selfChoice() {
    	$('#subEmail').val('')
    }
    
    function naverChoice() {
    	$('#subEmail').val('naver.com')
    	
    }
    
    function daumChoice() {
    	$('#subEmail').val('daum.net')
    }
    
    function gmailChoice() {
    	$('#subEmail').val('gmail.com')
    }

    function DaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                let addr = '';
                let extraAddr = '';

                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    document.getElementById('comAddr').value = extraAddr;
                
                } else {
                    document.getElementById('comAddr').value = '';
                }

                document.getElementById('comPostcode').value = data.zonecode;
                document.getElementById('comAddr').value = addr;
                document.getElementById('comDetailAddr').focus();
            }
        }).open();
    }
</script>
<style>
    form {
      margin-bottom: 7rem;
    }

    label {
      line-height: 1.6rem;
    }
    
    #searchpost{
      background-color: lightgray;
        color: black;
        margin-left: 1rem;    
    }
    #extraAddress{
        margin-top: 0.5rem;
    }
    #detailAddress {
      margin-left: .5rem;
      margin-top: .5rem;
    }
    #dropdown{
      margin-left: 0.5rem;
    }
</style>
</head>
<body>
<div class='container'>
    <div class='row title'></div>
    <div class='row p-5'>
        <div class='col'>
              <form class='form_box'>
                <label for='input-id'>아이디</label>
                <div class='input-group'>
                  <input type='text' class='form-control' id='companyId' name='id' readOnly>
                </div>
                <span id='idErrMsg'></span><br>
                <label for='password'>비밀번호</label>
                <input type='password' class='form-control' id='comPw' placeholder='숫자, 문자 포함 6자이상 15자이하로 입력하세요'>
                <span id='pwErrMsg'></span><br>
                <label for='password_confirm'>비밀번호 확인</label>
                <input type='password' class='form-control' id='comPwCheck' placeholder='비밀번호를 다시 입력하세요'>
                <span id='pwCheckErrMsg'></span><br>
                <label for='company_name'>회사명</label>
                <input type='text' class='form-control' id='comName' placeholder='-제외'>
                <span id='nameCheckErrMsg'></span><br>
                <label for='company_number'>사업자번호</label>
                <input type='text' class='form-control' id='comRegno' placeholder='-제외'>
                <span id='regnoErrMsg'></span><br>
                <div class='form-group'>
                    <label for='input-postcode'>주소</label>
                    <div class='input-group '>
                      <input type='number' class='form-control' id='comPostcode' name='postcode' placeholder='우편번호'>
                      <div class='input-group-append'>
                        <button class='btn' type='button' onclick='DaumPostcode()' id='searchpost'>우편번호찾기</button>
                      </div>
                    </div>
                    <div class='input-group'>
                      <input type='text' id='comAddr' class='form-control' name='extraAddress'>
                      <input type='text' id='comDetailAddr' class='form-control' name='detailAddress' placeholder='상세주소'>         
                    </div>                 
                </div>
                <span id='addrErrMsg'></span><br>
                <label for='president'>대표자명</label>
                <input type='text' class='form-control' id='president' >
                <span id='presidentErrMsg'></span><br>
                <div class='form-group'>
                    <label for='input-email'>대표 메일</label>
                    <div class='input-group'>
                        <input type='text' class='form-control' id='inputEmail'>
                        <h4>&nbsp; @ &nbsp;</h4>
                        <input type='text' class='form-control' id='subEmail'>
                        <div class='dropdown'>
                          <button type='button' class='btn dropdown-toggle' data-bs-toggle='dropdown'></button>
                          <div class='dropdown-menu'>
                              <a class='dropdown-item' onclick='selfChoice()'>직접입력</a>
                              <a class='dropdown-item' onclick='naverChoice()'>naver.com</a>
                              <a class='dropdown-item' onclick='daumChoice()'>daum.net</a>
                              <a class='dropdown-item' onclick='gmailChoice()'>gmail.com</a>
                          </div>
                        </div>
                    </div>
                </div>
                <span id='emailErrMsg'></span><br>
                <label>대표 전화번호</label>
                <input type='number' class='form-control' id='comPh' placeholder='-제외'>
                <span id='phErrMsg'></span><br>
                <br>
                <button type='button' id='fixCompanyBtn' class='btn btn-blue text-center'>수정완료</button><br>
            </form>
        </div>
        <div class='footer'></div>
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
                <button type='button' class='btn btn-blue' onclick="location.href='05.html'">확인</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>