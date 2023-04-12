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
<title>기업회원조회</title>
<script>
	let companyId = "${sessionScope.comId}"
	let companyPw = "${sessionScope.comPw}"
	let companyName = "${sessionScope.comName}"
	let companyRegno = "${sessionScope.comRegno}"
	let companyPostcode = "${sessionScope.comPostcode}"
	let companyAddr = "${sessionScope.comAddr}"
	let companyDetailAddr = "${sessionScope.comDetailAddr}"
	let president = "${sessionScope.president}"
		
	function listCompanys() {
		const companyArr = [];
		
		companyArr.push(`
			<tr>
		        <td>아이디</td>
		        <td>\${companyId}</td>
		    </tr>
		    <tr>
		        <td>비밀번호</td>
		        <td>\${companyPw}</td>
		    </tr>
		    <tr>
		        <td>회사명</td>
		        <td>\${companyName}</td>
		    </tr>
		    <tr>
		        <td>사업자번호</td>
		        <td>\${companyRegno}</td>
		    </tr>
		    <tr>
				<td>주소</td>
		        <td>\${companyPostcode +' '+ companyAddr +' '+ companyDetailAddr}</td>
		    </tr>
		    <tr>
		        <td>대표자명</td>
		        <td>\${president}</td>
		    </tr>
		`)
		$('#companys').append(companyArr.join(''));
	}
 	
	   
    $(() => {
    	input_admin_header()
        input_admin_sidebar()
        input_footer()
        btn_click()
        show_logout()
        listCompanys()
        
 		$('#companyDelBtn').click(() => {
 			$('#modalMsg').empty()
            $('#modalMsg').text('삭제하시겠습니까?')
            $('#modalBtn').show()
            $('#modal').modal('show')
            
            $('#modalOKBtn').off('click').on('click', function() {
	              $.ajax({
	                 url: '/admin/user/getcom/del/',
	                 method: 'delete'
       		    })
 		   	})   
   	    }); 
    }) 
</script>    
<style>
    #deluser {
        width: 10rem;
        height: 2rem;
        padding: 0;
    }

    tr th:last-child {
        padding-left: 25%;
    }
</style>
</head>
<body>
<div class='container'>
    <div class='row head'></div>
    <div class='row mt-5'>
        <div class='col-2 snb'></div>
        <div class='col'>
            <div class='row'>
                <div class='col'>
                    <h3><b>회원조회</b></h3>
                    <button type='button' class='btn btn-lightgray float-end' onclick='location.href="comlist"'>목록</button>
                </div>
            </div>
            <div class='row'>
                <div class='col'>
                    <table class='table'>
                        <thead>
                            <tr>
                                <th></th>
                                <th><b>회사정보</b></th>
                            </tr>
                        </thead>
                        <tbody id='companys'>
             
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class='row mt-5'>
        <div class='col d-flex justify-content-center'>
            <button type='button' class='btn btn-red' id='companyDelBtn'>삭제하기</button>
        </div>
        <div class='footer'></div>

        <div class='modal fadel' id='delmodal'>
            <div class='modal-dialog'>
                <div class='modal-content'>
                    <div class='modal-header'>
                        <button type='button' class='btn-close' data-bs-dismiss='modal'></button>
                    </div>
                    <div class='modal-body'>
                        <p id='modalMsg'></p>
                    </div>
                    <div class='modal-footer'>
                    <button type='button' class='btn btn-lightgray' data-bs-dismiss='modal'>취소</button>
                    <button type='button' class='btn btn-blue' onclick="location.href='./01.html'">확인</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>