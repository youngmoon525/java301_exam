<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>펑션</h1>
	<c:set var="str" value="     Hello Jsp Servlet" />
	<p>일반 EL 문자열 출력 ${str}</p>
	<p>대문자${fn:toUpperCase(str)}</p>
	<p>소문자${fn:toLowerCase(str)}</p>
	<p> 문자열 길이 ${fn:length(str)}</p>
	<p>공백을 제거 : ${fn:trim(str)}</p>
	<p>공백을 제거 후 길이 : ${fn:length(fn:trim(str))}</p>
	<p>JSP 문자를 JAVA로 바꿔보기 : ${fn:replace(str,"JSP","JAVA"}</p>
</body>
</html>