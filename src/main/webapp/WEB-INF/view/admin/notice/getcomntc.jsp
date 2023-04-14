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
<title>company 사내 공지사항 상세 조회</title>
<script>
	let companyId = "${sessionScope.comId}"

	const urlParams = new URLSearchParams(window.location.search);
	const companyNoticeNo = urlParams.get('companyNoticeNo');
	
	$(() => {
	    input_company_header()
	    input_company_sidebar()
	    input_footer()
	    btn_click()
	    show_logout()	    
	    getCompanyNotice()
	    
	    if(companyId != "${sessionScope.comId}") {
        	location.href='/company'
        }
	    
	    $('#delCompanyNoticeBtn').on('click', function() {
	    	$('#modalMsg').empty()
	    	$('#modalMsg').text('정말 삭제하시겠습니까?')
	    	$('#modalBtn').show()
	    	$('#modal').modal("show")
	    	
	    	$('#modalOkBtn').off('click').on('click', function() {
	    		$.ajax({
	    			url: 'getcomntc/del/' + companyNoticeNo,
	    			method: 'delete',
	    			success: move
	    		})
	    	})
	    })    
	})
		    
	function getCompanyNotice() {
		$.ajax({
			url: 'getcomntc/get',
			dataType: 'json',
			data: {
				companyNoticeNo: companyNoticeNo
			},
			success: companyNoticeDetail => {
				if(companyNoticeDetail.length) {
					const companyNoticeArr = [];
					
					$.each(companyNoticeDetail, (i, companyNotice) => {
						companyNoticeArr.unshift(
							`<thead>
								<tr>
									<th>\${companyNotice.comntcTitle}</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="white-space:pre;">\${companyNotice.comntcContent}</td>
								</tr>
							</tbody>`
						)
					})
					$('#companyNoticeDetail').append(companyNoticeArr.join(''));
				}
			}
		})
	}
	
	function move() {
		window.location.href="../notice/comntclist"
	}
</script>
<style>
    .table {
        border: .1rem solid;
        height: 20rem;
    }

    th {
        font-size: 1.2rem;
    }
    
    thead {
		background-color: #f0f0f1;
	}
</style>
</head>
<body>
<div class='container'>
    <div class='row header'></div>
    <div class='row mt-5'>
        <div class='col-2 snb'></div>
        <div class='col'>
            <div class='row pt-3'>
                <h3><b>사내 공지사항</b></h3>
            </div>
            <div class='row'>
                <div class='col mt-3'>
                    <table class='table' id='companyNoticeDetail'>
                        
                    </table>
                </div>
            </div>
            <div class='row'>
                <div class='col d-flex justify-content-end'>
                    <button type='button' class='btn me-3 btn-white' 
                    		 onclick="window.location.href=`fixcomntc?companyNoticeNo=\${companyNoticeNo}`">수정</button>
                    <button type='button' class='btn me-3 btn-secondary'  onclick="window.location.href='comntclist'">목록</button>
                    <button type='button' class='btn btn-red' id='delCompanyNoticeBtn'>삭제</button>
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
                <button type='button' class='btn btn-lightgray' id='modalCancelBtn' data-bs-dismiss='modal'>취소</button>
                <button type='button' class='btn m-2 btn-blue' id='modalOkBtn'>확인</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>