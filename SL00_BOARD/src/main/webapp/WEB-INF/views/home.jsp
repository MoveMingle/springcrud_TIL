<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
   uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="../images/SiSt.ico">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
</head>
<body>
   <header>
      <h1>Spring Board</h1>
      <ul>
         <sec:authorize access="isAnonymous()">
            <li><a href="#">로그인</a></li>
         </sec:authorize>
         <sec:authorize access="isAuthenticated()">
            <li><a href="#">로그아웃</a></li>
         </sec:authorize>
         <li><a href="#">회원가입</a></li>
      </ul>
   </header>
   <div>
      <h3>
         <span class="material-symbols-outlined" style="vertical-align: sub">home</span>스프링
         Board
      </h3>
      <pre class="code">
   create table tbl_board
(
    bno number(10) primary key
    , title varchar2(200) not null
    , content varchar2(2000) not null
    , writer varchar2(50) not null
    , regdate date default sysdate
    , updatedate date default sysdate
    );
    create sequence seq_board;
    commit;
    select * from tbl_board;
    
    
    
    org.do.it.service
    ㄴ board
    
   </pre>
   </div>
</body>
</html>