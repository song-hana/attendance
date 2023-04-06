
// user용 헤더
function input_user_header() {
    let header_txt = ''
    let navigation = ''

    header_txt += ' <div class="col">'
    header_txt += '     <div class="row">'
    header_txt += '          <div class="col ham">'
    header_txt += '             <button type="button" class="btn gnb_btn"><i class="fa-solid fa-bars"></i></button>'
    header_txt += '             <ul class="gnb collapse">'
    header_txt += '                 <li><a href="../notice/01.html">공지사항</a></li>'
    header_txt += '                 <li><a href="../ask/01.html">문의사항</a></li>'
    header_txt += '             </ul>'
    header_txt += '          </div>'
    header_txt += '          <div class="col logo">'
    header_txt += `             <div class="logo_img text-center" onclick="main">로고이미지</div>`
    header_txt += '          </div>'
    header_txt += '          <div class="col mt-1 float-end lnb_btn">'
    header_txt += '             <a href="user/login" class="float-end collapse show" id="login_btn"><i class="fa-solid fa-user"></i></a>'
    header_txt += '             <a href="#" class="float-end collapse" id="showLnb"><i class="fa-solid fa-user"></i></a>'
    header_txt += '             <ul class="lnb collapse">'
    header_txt += '                 <li><a href="../getholiday">연차관리</a></li>'
    header_txt += '                 <li><a href="../work/01.html">근로내역</a></li>'
    header_txt += '                 <li><a href="../user/04.html">비밀번호<br>변경</a></li>'
    header_txt += '                 <li><a href="logout">로그아웃</a></li>'
    header_txt += '             </ul>'
    header_txt += '          </div>'
    header_txt += '     </div>'
    header_txt += ' </div>'

    navigation += ' <div class="row">'
    navigation += '     <div class="col text-center">'
    navigation += '         <a href="../notice/03.html"><i class="fa-solid fa-list"></i></a>'
    navigation += '     </div>'
    navigation += '     <div class="col text-center">'
    navigation += '         <a href="../work/02.html"><i class="fa-solid fa-check-to-slot"></i></a>'
    navigation += '     </div>'
    navigation += '     <div class="col text-center">'
    navigation += '         <a href="../getplan"><i class="fa-regular fa-calendar"></i></a>'
    navigation += '     </div>'
    navigation += ' </div>'

    $('.header').append(header_txt)
    $('.navigation').append(navigation)
}


// company용 헤더
function input_company_header() {
    let header_txt = ''

    header_txt += ' <div class="col">'
    header_txt += '     <div class="row">'
    header_txt += '          <div class="col ham">'
    header_txt += '             <button type="button" class="btn gnb_btn"><i class="fa-solid fa-bars"></i></button>'
    header_txt += '             <ul class="gnb collapse">'
    header_txt += '                 <li><a href="../notice/01.html">공지사항</a></li>'
    header_txt += '                 <li><a href="../ask/01.html">문의사항</a></li>'
    header_txt += '             </ul>'
    header_txt += '          </div>'
    header_txt += '          <div class="col logo">'
    header_txt += `             <div class="logo_img text-center" onclick="location.href='../main.html'">로고이미지</div>`
    header_txt += '          </div>'
    header_txt += '          <div class="col btns mt-1 text-end">'
    header_txt += '             <a href="../user/01.html" class="collapse show">로그인</a>'
    header_txt += '             <a href="../user/04.html" class="collapse show">회원가입</a>'
    header_txt += '             <a href="../main.html" class="collapse" id="logout">로그아웃</a>'
    header_txt += '             <a href="../notice/03.html" class="collapse">마이페이지</a>'
    header_txt += '          </div>'
    header_txt += '     </div>'
    header_txt += ' </div>'

    $('.header').append(header_txt)
}

function show_logout() {
    $('.btns a').eq(0).removeClass('show')
    $('.btns a').eq(1).removeClass('show')
    $('.btns a').eq(2).addClass('show')
    $('.btns a').eq(3).addClass('show')
    $('.lnb_btn>a').eq(0).removeClass('show')
    $('.lnb_btn>a').eq(1).addClass('show')
}

function show_login() {
    $('.btns a').eq(0).addClass('show')
    $('.btns a').eq(1).addClass('show')
    $('.btns a').eq(2).removeClass('show')
    $('.btns a').eq(3).removeClass('show')
    $('.lnb_btn>a').eq(0).addClass('show')
    $('.lnb_btn>a').eq(1).removeClass('show')
    $('.navigation a').attr('href', 'employee/login')
}

// admin용 헤더
function input_admin_header() {
    let header_txt = ''

    header_txt += ' <div class="col">'
    header_txt += '     <div class="row">'
    header_txt += '          <div class="col"></div>'
    header_txt += '          <div class="col logo">'
    header_txt += '             <div class="logo_img text-center">로고이미지</div>'
    header_txt += '          </div>'
    header_txt += '          <div class="col btns mt-1 text-end">'
    header_txt += '             <a class="collapse show">로그아웃</a>'
    header_txt += '          </div>'
    header_txt += '     </div>'
    header_txt += ' </div>'


    $('.header').append(header_txt)
}

//admin 로그인 후 snb
function input_admin_sidebar() {
    let sideBar =''

    sideBar += '     <ul>'
    sideBar += '         <br>'
    sideBar += '         <li><a href="../notice/07.html">공지사항</a></li><br>'
    sideBar += '         <li><a href="../ask/04.html">문의사항</a></li><br>'
    sideBar += '         <li><a href="../user/11.html">회원 조회</a></li>'
    sideBar += '     </ul>'

    $('.snb').append(sideBar)
}

// company 로그인 후 snb
function input_company_sidebar() {
    let sideBar =''

    sideBar += '     <ul>'
    sideBar += '         <br>'
    sideBar += '         <li><a href="../notice/03.html">사내 공지</a></li><br>'
    sideBar += '         <li><a href="../user/07.html">직원 조회</a></li><br>'
    sideBar += '         <li><a href="../work/01.html">직원 근태 목록</a></li><br>'
    sideBar += '         <li><a href="../plan/01.html">사내 일정</a></li><br>'
    sideBar += '         <li><a href="../user/05.html">회사 정보</a></li><br>'
    sideBar += '     </ul>'

    $('.snb').append(sideBar)
}

// 로그인 등 폼으로 구성된 페이지 용 헤더
function input_form_header() {
    let header_txt = ''

    header_txt += ' <div class="col">'
    header_txt += '     <div class="center_logo text-center" onclick="history.go(-1)">로고이미지</div>'
    header_txt += ' </div>'

    $('.title').append(header_txt)
}

//footer 공통 사항
function input_footer() {
    let footer_txt = ''


    footer_txt += ' <div class="footer_body">'
    footer_txt += '     <p class="text-center footer_txt">'
    footer_txt += '         HANAWORKS 하나웍스 &nbsp; 서울 관악구 신림로 340 6층 대표이사: 송하나<br>'
    footer_txt += '         사업자등록번호: 105-80-00187 &nbsp; 대표전화: 1588-1859(발신자 부담 전화)<br>'
    footer_txt += '         COPYRIGHT HANAWORKS COMPANY ALL RIGHTS RESERVED'
    footer_txt += '     </p>'
    footer_txt += ' </div>'

    $('.footer').append(footer_txt)
}

// click 기능 모음
function btn_click() {
    $('.gnb_btn').click(() => 
        $('.gnb').toggleClass('show')
    )

    $('#showLnb').click(() => 
        $('.lnb').toggleClass('show')
    )
}