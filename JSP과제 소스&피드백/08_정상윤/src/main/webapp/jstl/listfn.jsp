<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

	<!-- jstl Functions -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>펑션 (EL태그 안에 사용)</h1>
	<c:set var="str" value=" Hello Jsp Servlet"/>
	<p> 일반 EL문자열 출력 : ${str }</p>
	<p> 대문자로 바꾸기(fn:toUpperCase) : ${fn:toUpperCase(str) }</p>
	<p> 소문자로 바꾸기(fn:toLowerCase) : ${fn:toLowerCase(str) }</p>
	<p> 문자열의 길이(fn:length(str)) : ${fn:length(str) }</p>
	<p> 공백제거 (fn:trim()): ${fn:length(str) }</p>
	<p> 공백제거 후 길이 : ${fn:length( fn:trim(str) ) }</p>
	<p> Jsp문자를 JAVA로 바꿔보기(fn:replace(변수, "바꿀문자","바뀔문자")): ${fn:replace(str, "Jsp", "JAVA" ) }</p>
	
</body>
</html>