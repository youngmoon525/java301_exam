<%@page import="employee.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1 style="text-align: center;">사원정보를 보여 줍니다</h1>
	<table class="styled-table">
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>이메일</th>
				<th>부서코드</th>
				<th>전화번호</th>
				<th>부서명</th>
				<th>주소</th>
				<th>부서최대급여</th>
				<th>부서최소급여</th>
				<th>부서평균급여</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.employee_id }</td>			
				<td>${dto.name }</td>			
				<td>${dto.e_mail }</td>			
				<td>${dto.department_id }</td>			
				<td>${dto.phone_number }</td>			
				<td>${dto.department_name }</td>			
				<td>${dto.addr }</td>			
				<td>${dto.max_sal }</td>			
				<td>${dto.min_sal }</td>			
				<td>${dto.avg_sal }</td>			
						
			</tr>			
		</c:forEach>
		</tbody>
	</table>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>