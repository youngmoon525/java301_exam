<%@ page import="employees.EmpDTO" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 조회</title>

</head>
<body>
<!-- $ <- 동적으로 request에 있는 자원에 접근해서 사용 -->
	<%@ include file="/include/header.jsp" %>
	<h1>사원목록조회</h1>
	<table class="styled-table">
		<thead>
			<tr>
				<th>NO</th>
				<th>사번</th>
				<th>이름</th>
				<th>email</th>
				<th>부서코드</th>
				<th>휴대전화</th>
				<th>부서명</th>
				<th>전체주소</th>
				<th>부서최대급여</th>
				<th>부서최소급여</th>
				<th>부서평균급여</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="dto">
				<tr>
					<td>${dto.eid}</td><!-- ?? -->
					<td>${dto.eid}</td>
					<td>${dto.name}</td>
					<td>${dto.email}</td>
					<td>${dto.did}</td>
					<td>${dto.phone}</td>
					<td>${dto.dname}</td>
					<td>${dto.adrAll}</td>
					<td>${dto.max_sal}</td>
					<td>${dto.min_sal}</td>
					<td>${dto.avg_sal}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>