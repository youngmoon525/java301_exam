<%@page import="hr.HrDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hr.HrDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"> 
	th{
		cursor: pointer;
	}
</style>
<script type="text/javascript">
	function sortTable(n){
		
		    
		var table, rows, switching, o, x, y, shouldSwitch, dir, switchcount = 0;
		table = document.getElementById("hrlist");
		switching = true;
		dir = "asc";
		
		//추가해야함 : 길이로  먼저 걸러서 정렬하기!!!!!!!!!!!!!!!!!!!
		
		
		
		while(switching){
			switching = false;
			rows = table.getElementsByTagName("tr");
			
			for (o = 1; o < rows.length -1 ; o++) {
				shouldSwitch = false;
				x = rows[o].getElementsByTagName("td")[n];
				y = rows[o+1].getElementsByTagName("td")[n];
				
				if(n < 6){
					
					if(dir =="asc"){
							if(x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()){
								shouldSwitch = true;
								break;
							}
					}else if(dir == "desc"){
							if(x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()){
								shouldSwitch = true;
								break;
							}
					}
					
				}else if(n ==6 || n==7 || n==8) {
						x = Number(x);
						y = Number(y);
					if(dir =="asc"){
						
						if(x > y){
							shouldSwitch = true;
							break;
						
						}
					}else if(dir == "desc"){

						if(x < y){
							shouldSwitch = true;
							break;
						}
						
					}
					
				}
				
				
			}//for
			
			if(shouldSwitch){
				rows[o].parentNode.insertBefore(rows[o + 1], rows[o]);
				switching = true;
				switchcount ++;
			}else{
				if(switchcount == 0 && dir == "asc"){
					dir = "desc";
					switching = true;
				}
			}
		}//while
		
		
	}
</script>
</head>
<body>
<%@ include file="/include/header.jsp"%>
	
	<h1 style="text-align: center;">사원정보를 보여 줍니다</h1>

	<table class="styled-table" id="hrlist">
		<thead>
			<tr>
				<th onclick="sortTable(0)">사번</th>
				<th onclick="sortTable(1)">이름</th>
				<th onclick="sortTable(2)">이메일</th>
				<th onclick="sortTable(3)">휴대전화</th>
				<th onclick="sortTable(4)">부서명</th>
				<th onclick="sortTable(5)">전체주소</th>
				<th onclick="sortTable(6)">부서최대급여</th>
				<th onclick="sortTable(7)">부서최소급여</th>
				<th onclick="sortTable(8)">부서평균급여</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${list }" var="dto">
		<tr> 
					<td><a href="#">${dto.employee_id } </a></td>
					<td><a href="#">${dto.name } </a></td>
					<td><a href="#">${dto.email } </a></td>
					<td><a href="#">${dto.phone_number } </a></td>
					
			<c:choose>
				<c:when test="${not empty dto.department_name }">	
					<td><a href="#">${dto.department_name } </a></td>
					<td><a href="#">${dto.address } </a></td>
					<td><a href="#"><f:formatNumber value="${dto.max_sal }" pattern="##,###"></f:formatNumber></a></td>
					<td><a href="#"><f:formatNumber value="${dto.min_sal }" pattern="##,###"></f:formatNumber></a></td>
					<td><a href="#"><f:formatNumber value="${dto.avg_sal }" pattern="##,###.00"></f:formatNumber> </a></td>
				</c:when>
				<c:otherwise>
					<td><a href="#">정보없음 </a></td>
					<td><a href="#">정보없음 </a></td>
					<td><a href="#">정보없음 </a></td>
					<td><a href="#">정보없음 </a></td>
					<td><a href="#">정보없음 </a></td>
				</c:otherwise>	
			</c:choose>
		</tr>
	</c:forEach>	
	
				<!-- 인풋타입사용해서 -->
		</tbody>
	</table>
	
	
	<%@ include file="/include/footer.jsp"%>

</body>
</html>