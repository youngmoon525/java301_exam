<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포맷태그 사용</h1>
	<!-- 변수 date를 현재 날짜로 초기화함 -->
	<c:set var="date" value="<%=new Date() %>"></c:set>
	<p>현재 시간을 EL로 표현 : ${date }</p><br>
	<p>오늘의 날짜(type: date) FMT태그 : <f:formatDate value="${date }" type="date"/></p>
	<p>오늘의 시간(type: time) FMT태그 : <f:formatDate value="${date }" type="time"/></p>
	<p>날짜 시간(type: both) FMT태그 : <f:formatDate value="${date }" type="both"/></p>
	<p>포맷을 이용한 패턴 : <f:formatDate value="${date }" type="date" pattern="yyyy년 MM월 dd일(E)"/></p>
	
	<!-- 변수 num에 123456789 초기화하고 수 표현양식  -->
	<c:set var="num" value="123456789" />
	<p>현재 숫자를 EL로 그냥 표현하기 : ${num }</p>
	<p>FMT이용 그루핑 사용 : <f:formatNumber value="${num }" groupingUsed="true"></f:formatNumber> </p>
	<p>FMT이용 그루핑 미사용 : <f:formatNumber value="${num }" groupingUsed="false"></f:formatNumber> </p>
	<p>FMT이용 패턴 : <f:formatNumber value="${num }" pattern="#,##0원"></f:formatNumber> </p>
	
	<!-- 기타포맷 : 통화기호, 백분율-->
	<p>금액1 (type: currency) : <f:formatNumber value="${num }" type="currency" /> </p>
	<p>금액2 (type: currency, currencySymbol : $): <f:formatNumber value="${num }" type="currency"  currencySymbol="$"/> </p>
	<p>퍼센트1 (type: percent): <f:formatNumber value="0.123" type="percent"  /> </p>
	<p>퍼센트2 (pattern="0.00%"): <f:formatNumber value="0.123"  pattern="0.00%"  /> </p>
</body>
</html>