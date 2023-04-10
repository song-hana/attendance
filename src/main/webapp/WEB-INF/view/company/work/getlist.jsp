<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js'></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
<script src='<c:url value="/res/common.js"/>'></script>
<link rel='stylesheet' href='<c:url value="/res/common.css"/>'>
<title>직원 근태 목록</title>
<script>
    $(() => {
        input_company_header()
        input_company_sidebar()
        input_footer()
        btn_click()
        show_logout()
    })

    
    $(function() {
        let today = new Date();
        let dateString = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();

        $("#datepicker").datepicker({
            changeMonth: true, 
            changeYear: true,
            minDate: '-50y',
            nextText: '다음 달',
            prevText: '이전 달',
            yearRange: 'c-50:c+20',
            showButtonPanel: true, 
            currentText: '오늘 날짜',
            closeText: '닫기',
            dateFormat: "yy-mm-dd",
            showAnim: "slide",
            showMonthAfterYear: true, 
            dayNamesMin: ['일','월', '화', '수', '목', '금', '토'],
            monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
            showOn: 'button',
            buttonText: '<i class="far fa-calendar "></i>',

            onSelect: function(date) {
                today = new Date(date);
                dateString = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
                $("#toDay").text(dateString);
            }
        });

        function displayToday() {
            $("#toDay").prepend(dateString);
        }

        displayToday();

        $("#prevDay").click(function() {
            let prevDate = new Date(today);
            prevDate.setDate(today.getDate() - 1);
            let prevDateString = prevDate.getFullYear() + "-" + (prevDate.getMonth() + 1) + "-" + prevDate.getDate();
            $("#toDay").text(prevDateString);
            today = prevDate;
            console.log($('#toDay').val())
        });

        $("#nextDay").click(function() {
            let nextDate = new Date(today);
            nextDate.setDate(today.getDate() + 1);
            let nextDateString = nextDate.getFullYear() + "-" + (nextDate.getMonth() + 1) + "-" + nextDate.getDate();
            $("#toDay").text(nextDateString);
            today = nextDate;
        });
    });
</script>
<style>
    #prevDay, #nextDay {
        color: white;
        background-color: darkslateblue;
    }

    #prevDay, #nextDay {
        flex: 0 0 auto;
        width: 2rem;
        height: 2rem;
        margin: .3rem;
        padding: 0;
    }

    #toDay {
        display: inline-block;
        font-size: 1.75em;
        margin: 0;
    }

    .ui-datepicker-trigger {
        background-color: white;
        border: none;
    }
    .far.fa-calendar {
        font-size: 1.75rem;
    }

    .ui-widget-header { border: none; background-color: white; }
    .ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default, .ui-button, html .ui-button.ui-state-disabled:hover, html .ui-button.ui-state-disabled:active {
        border: 1px solid #fff;
        background: #fff;
        text-align: center !important;
        font-size: 1.1rem;
    }
    a.ui-state-default.ui-state-active {
        background: #0A21A6;
    }

    .ui-widget.ui-widget-content {
        width: 18rem;
    }

    .ui-datepicker .ui-datepicker-title {
        font-size: 1.2rem;
    }

    .ui-datepicker .ui-datepicker-header {
        width: 100%;
    }

    .ui-datepicker th {
        font-size: 1.2rem;
        padding: 0.4rem;
    }

    .ui-datepicker-calendar th:first-child {
        color: #A6231B;
    }

    .ui-datepicker-calendar th:nth-last-child(1) {
        color: #0A21A6;
    }

    .ui-datepicker-calendar tr td:first-child a {
        color: #A6231B;
    }

    .ui-datepicker-calendar tr td:nth-last-child(1) a {
        color: #0A21A6;
    }
</style>
</head>
<body>
<div class='container'>
    <div class='row header'></div>
    <div class='row mt-5'>
        <div class='col-2 snb'></div>
        <div class='col'>
            <div class='row'>
                <div class='col mb-3'>
                    <h3><b>직원 근태 목록</b></h3>
                </div>
            </div>    
            <div class='row'>
                <div class='col'>
                    <button type='button' class="btn" id='prevDay'>
                        <i class="fa-solid fa-chevron-left"></i>
                    </button>
                    <button type='button' class="btn me-5" id='nextDay'>
                        <i class="fa-solid fa-chevron-right"></i>
                    </button>
                    <input type='text' id="datepicker" class="collapse">
                    <div class='ps-4' id='toDay'></div>
                </div>
            </div>
            <div class='row'>
                <div class='col'>
                    <table class='table'>
                        <thead>
                            <tr><th>일자</th><th>이름</th><th>직급</th><th>출근</th><th>퇴근</th><th>근무시간</th><th>추가근무시간</th><th>비고</th></tr>
                        </thead>
                        <tbody>
                            <tr><td>2023-03-21</td><td>김이젠</td><td>사장</td><td>09:30</td><td>20:00</td><td>9h</td><td>2h</td><td></td></tr>
                            <tr><td>2023-03-21</td><td>최한석</td><td>과장</td><td>08:50</td><td>18:00</td><td>9h</td><td>0</td><td></td></tr>
                            <tr><td>2023-03-21</td><td>한아름</td><td>대리</td><td>00:00</td><td>00:00</td><td>0</td><td>0</td><td>연차</td></tr>
                            <tr><td>2023-03-21</td><td>김철수</td><td>사원</td><td>08:40</td><td>20:17</td><td>9h</td><td>2h</td><td></td></tr>
                            <tr><td>2023-03-21</td><td>양승일</td><td>인턴</td><td>08:00</td><td>18:00</td><td>9h</td><td>0</td><td></td></tr>
                            <tr><td>2023-03-21</td><td>송하나</td><td>사장</td><td>08:55</td><td>22:24</td><td>9h</td><td>4h</td><td></td></tr>
                            <tr><td>2023-03-21</td><td>김민형</td><td>과장</td><td>08:50</td><td>18:00</td><td>9h</td><td>0</td><td></td></tr>
                            <tr><td>2023-03-21</td><td>최서영</td><td>대리</td><td>00:00</td><td>00:00</td><td>0h</td><td>0</td><td>연차</td></tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class='footer'></div>
</div>
</body>
</html>