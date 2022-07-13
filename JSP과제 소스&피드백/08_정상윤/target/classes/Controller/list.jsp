<%@page import="java.util.List"%>
<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="customer.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 관리 모듈</title>
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
	
	<h1 style="text-align: center;">고객정보를 보여 줍니다</h1>

	<table class="styled-table" id="hrlist">
		<thead>
			<tr>
				<th onclick="sortTable(0)">ID</th>
				<th onclick="sortTable(1)">NAME</th>
				<th onclick="sortTable(2)">GENDER</th>
				<th onclick="sortTable(3)">EMAIL</th>
				<th onclick="sortTable(4)">PHONE</th>
	
			</tr>
		</thead>
		<tbody>
			
	<%	
		List<CustomerDTO> list =  (List<CustomerDTO>) request.getAttribute("list");
	
		for(int i = 0 ;  i<list.size(); i ++){ %>
	
			<tr> 
				<td><a href="#"><%=list.get(i).getId() %></a></td>
				<td><a href="#"><%=list.get(i).getName()%></a></td>
				<td><a href="#"><%=list.get(i).getGender()%></a></td>
				<td><a href="#"><%=list.get(i).getEmail()%></a></td>
				<td><a href="#"><%=list.get(i).getPhone()%></a></td>
			</tr>
	<%	} %>
				<!-- 인풋타입사용해서 -->
		</tbody>
	</table>
	
	
	<%@ include file="/include/footer.jsp"%>

</body>
</html>