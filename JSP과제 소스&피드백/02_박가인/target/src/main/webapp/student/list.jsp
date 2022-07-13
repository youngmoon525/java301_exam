<%@page import="java.util.ArrayList"%>
<%@page import="student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	border-collapse:collapse;
}
th,td{	border: 1px solid black;}
</style>
<title>학생 정보 보기</title>
</head>
<body>
<!--  student_no, student_name, user_id, first_name, last_name,-->
<%@ include file="../include/header.jsp" %>
	<table>
	
<% 
	ArrayList<StudentDTO> list = ( ArrayList<StudentDTO> ) request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
		%>
		
		<tr>
		
	<td><a href="detail.st?studentno=<%=list.get(i).getStudent_no() %>&user_id=<%=list.get(i).getUser_id()%>"><%=list.get(i).getStudent_no() %></a></td> <!-- form태그도 됨 -->
	<td><a href="detail.st"><%=list.get(i).getStudent_name()%></a></td>
	<td><p><%=list.get(i).getStudent_no()%></p></td>
	<td><p><%=list.get(i).getUser_id()%></p></td>
	<td><p><%=list.get(i).getFirst_name()%></p></td>
	<td><p><%=list.get(i).getLast_name()%></p></td>

		
		
		<td>
		<form action="detail.st" method="get">
			<input type="hidden" name="studentno" value="<%=list.get(i).getStudent_no() %>">
			<input type="hidden" name="user_id" value="<%=list.get(i).getUser_id() %>">
			<input type="submit" value="detail.st로 요청">
		</form>
		</td>
		</tr>
	<% } %>	
	
	

</table>
	 <%@include file="../include/footer.jsp" %>
</body>
</html>