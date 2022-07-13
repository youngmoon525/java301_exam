<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis(사원목록조회) 과제</title>
<style type="text/css">
table {
  font-family: 'Arial';
  margin: 25px auto;
  border-collapse: collapse;
  border: 1px solid #eee;
  border-bottom: 2px solid #00cccc;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1), 0px 10px 20px rgba(0, 0, 0, 0.05), 0px 20px 20px rgba(0, 0, 0, 0.05), 0px 30px 20px rgba(0, 0, 0, 0.05);
}
table tr:hover {
  background: #f4f4f4;
}
table tr:hover td {
  color: #555;
}
table th, table td {
  color: #999;
  border: 1px solid #eee;
  padding: 12px 35px;
  border-collapse: collapse;
}
table th {
  background: #00cccc;
  color: #fff;
  text-transform: uppercase;
  font-size: 12px;
}
table th.last {
  border-right: none;
}

h3 {
  margin : 0px auto;
  text-align: center;
  padding: 30px;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp" %>

	<h3>사원 정보 보기</h3>
	<table>
		<!-- 번호 사번 이름 이메일 department_id 휴대전화 부서명 전체주소 부서최대급여 부서최소급여 부서평균급여 department_id_1 -->
		<tr>
			<th>번호</th>
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
	
		
		<!-- 
		 , , , , , , ;
	
		 -->
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
			<td>${dto.max_sal}</td>
			<td>${dto.min_sal}</td>
			<td>${dto.avg_sal}</td>
			<td>${dto.department_id_1}</td>
		</tr>
		</c:forEach>
	</table>	
	
	<%@ include file="/include/footer.jsp" %>
</body>
</html>