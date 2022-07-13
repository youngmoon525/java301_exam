<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL 태그를 이용하기 위한 준비 ↑  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- $<-동적으로 request에 있는 자원에 접근해서 사용
  -->
	<%@ include file="/include/header.jsp"%>
	<h1>고객관리 모듈(JSTL)</h1>
	
	<table class="styled-table">
		<thead>
			<tr>
				<th>NO</th>
				<th>사번</th>
				<th>이름</th>
				<th>이메일</th>
				<th>휴대전화</th>
				<th>부서명</th>
				<th>전체주소</th>
				<th>부서최대급여</th>
				<th>부서최소급여</th>
				<th>부서평균급여</th>
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.no}</td>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
			<td>${dto.dname}</td>
			<td>${dto.arr}</td>
			<td>${dto.max}</td>
			<td>${dto.min}</td>
			<td>${dto.avg}</td>
		</tr>
	</c:forEach>
	
	
			</tbody>
	</table>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>