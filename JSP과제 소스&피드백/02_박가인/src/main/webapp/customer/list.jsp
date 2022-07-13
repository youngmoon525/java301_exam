<%@page import="java.util.List"%>
<%@page import="customer.CustomerDTO"%>
<%@page import="customer.CustomerDAO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>고객정보 조회</h1>
	<table class="styled-table">
		<thead>
			<tr>
				<th>id</th>
				<th>이름</th>
				<th>성별</th>
				<th>이메일</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
			<%List<CustomerDTO> list = (List<CustomerDTO>)request.getAttribute("list");
			for(int i = 0; i<list.size(); i++ ){
				%>
			<tr>
				<td><a><%=list.get(i).getId() %></a></td>
				<td><a><%=list.get(i).getName()%></a></td>
				<td><a><%=list.get(i).getGender()%></a></td>
				<td><a><%=list.get(i).getEmail()%></a></td>
				<td><a><%=list.get(i).getPhone()%></a></td>
				
			</tr>
			<%} %>
		</tbody>
	</table>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>