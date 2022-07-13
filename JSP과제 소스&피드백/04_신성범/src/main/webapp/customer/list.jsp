<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/include/header.jsp" %>
	<h1 style="text-align: center;">고객 정보 조회</h1>
	<table class="styled-table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>이메일</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<% ArrayList<CustomerDTO> list = (ArrayList<CustomerDTO>)request.getAttribute("list"); 
			for(int i = 0; i < list.size(); i++){
		%>
		<tbody>
			<tr>
				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getName()%></td>
				<td><%=list.get(i).getGender()%></td>
				<td><%=list.get(i).getEmail()%></td>
				<td><%=list.get(i).getPhone()%></td>
			</tr>
		</tbody>
	<%} %>
	</table>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>