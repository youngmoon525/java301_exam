<%@page import="employees.EmployeesDTO" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록조회</title>
</head>
<body>
	<%@ include file = "/include/header.jsp" %>
	<h1>사원목록조회</h1>
	<table class="styled-table">
		<tr>
			<th>NO</th>
			<th>사번</th>
			<th>이름</th>
			<th>이메일</th>
			<th>department_id</th>
			<th>휴대전화</th>
			<th>부서명</th>
			<th>전체주소</th>
			<th>부서최대급여</th>
			<th>부서최소급여</th>
			<th>부서평균급여</th>
			<th>department_id_1</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.no}</td>
				<td>${dto.employee_id}</td>	
				<td>${dto.name}</td>	
				<td>${dto.email}</td>	
				<td>${dto.department_id}</td>	
				<td>${dto.phone_number}</td>	
				<td>${dto.department_name}</td>	
				<td>${dto.address}</td>	
				<td>${dto.max}</td>	
				<td>${dto.min}</td>	
				<td>${dto.avg}</td>
				<td>${dto.department_id}</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file = "/include/footer.jsp" %>
</body>
</html>