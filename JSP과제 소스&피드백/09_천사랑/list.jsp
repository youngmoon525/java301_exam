<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1 style="text-align: center;">사원 목록 조회</h1>
	<table class="styled-table">
		<thead>
			<tr>
				<th>no</th>
				<th>사번</th>
				<th>이름</th>
				<th>이메일</th>
				<th>DEPARTMENT_ID</th>
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
			<td><p>${dto.no}</p></td>
			<td><p>${dto.employee_id}</p></td>
			<td><p>${dto.name}</p></td>
			<td><p>${dto.email}</p></td>
			<td><p>${dto.department_id}</p></td>
			<td><p>${dto.phone_number}</p></td>
			<td><p>${dto.department_name}</p></td>
			<td><p>${dto.address}</p></td>
			<td><p>${dto.salary_max}</p></td>
			<td><p>${dto.salary_min}</p></td>
			<td><p>${dto.salary_avg}</p></td>
			
		
		</tr>
	
	</c:forEach>
	
	
		</tbody>
	</table>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>