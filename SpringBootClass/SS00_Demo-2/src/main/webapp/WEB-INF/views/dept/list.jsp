<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SS</title>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<link href="/resources/dipin/example.css" type="text/css" rel="stylesheet" />
<script   src="/resources/dipin/example.js"></script>
</head>
<body>
<div>
  <h1 class='main'>JSP DEPT LIST</h1>
  
  <table>
    <tr>
      <th>deptno</th>
      <th>dname</th>
      <th>loc</th>
    </tr>
    <c:forEach items="${ list }" var="vo">
    <tr>
      <td>${ vo.deptno }</td>
      <td>${ vo.dname }</td>
      <td>${ vo.loc }</td>
    </tr>
    </c:forEach>
    
  </table>
</div>
</body>
</html>