<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL 태그를 이용하기 위한 준비 ↑  -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#new_btn{
		position: fixed;
		right: 20%;
		top: 20%;
		z-index: 999;
	}
	th{
		cursor: pointer;
	}

</style>
<script type="text/javascript">
	function sortTable(n){
		
		    
		var table, rows, switching, o, x, y, shouldSwitch, dir, switchcount = 0;
		table = document.getElementById("culist");
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- $<-동적으로 request에 있는 자원에 접근해서 사용
  -->
	<%@ include file="/include/header.jsp"%>
	<h1 style="text-align: center;">고객관리 모듈(JSTL)</h1>
	<button type="button"  id="new_btn" class="btn btn-primary" onclick="showModalInsert();" >신규 고객 추가</button>
	
	<table class="styled-table" id="culist">
		<thead>
			<tr>
				<th onclick="sortTable(0)">아이디</th>
				<th onclick="sortTable(1)">이름</th>
				<th onclick="sortTable(2)">성별</th>
				<th onclick="sortTable(3)">이메일</th>
				<th onclick="sortTable(4)">핸드폰</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.gender}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
			<td>
			
			<!-- EL문법으로 showModal에 파라메터를 하나 전송, 전송된 파라메터 alert로 출력  -->
			<button type="button"  class="btn btn-secondary" onclick="showModal('${dto.id}', '${dto.name}' ,'${dto.gender}','${dto.email}','${dto.phone}' );" >정보 수정</button>
			</td>
		</tr>
	</c:forEach>
	
			</tbody>
	</table>
	
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">고객 추가</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
    
          <div class="mb-3">
            <input type="text" style="display:none;" class="form-control" name="id" id="recipient-id" value=""> <!-- ajax통해서 전송하기위한 태그 -->
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이름</label>
            <input type="text" name="name" class="form-control" id="recipient-name">
            <input type="hidden" name="id">
          </div>
           <div class="mb-3">
            <label for="recipient-gender" class="col-form-label">성별</label>
            <input type="radio" checked="checked" name="gender" value="남" id="recipient-gender" />남
            <input type="radio" name="gender" value="여" />여
          </div>
           <div class="mb-3">
            <label for="recipient-email" class="col-form-label">이메일</label>
            <input type="text" name="email" class="form-control" id="recipient-email">
          </div>
          <div class="mb-3">
            <label for="recipient-phone" class="col-form-label">핸드폰</label>
            <input type="text" name="phone" class="form-control" id="recipient-phone">
          </div>

        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" name="submit"  onclick="addCustomer();">추가</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
	
	
	<%@ include file="/include/footer.jsp"%>
	
	<script type="text/javascript">
		function showModalInsert() {
			$('[name=name]').val('');
		  
		  	$('[name=email]').val('');
  	 		$('[name=phone]').val('');
  	 		
			$('#exampleModal').modal('show');//hide 숨김
			$('[name=submit]').attr('onclick','addCustomer()');
		}
		
		
		//넘어온 파라메터 출력해보기
		function showModal(id, name, gender, email, phone) {
			   $('[name=id]').val(id);
			   $('[name=name]').val(name);
			   $('[name=gender]').attr('checked',false);
			   //▶ 나중에 제이쿼리로 처리
			   if(gender =='남'){
				   $("input:radio[name=gender]:input[value='남']").attr('checked',true);
				
			   }else{
				   $("input:radio[name=gender]:input[value='여']").attr('checked',true);
				   
			   }   
			   
			   //} 
			   $('[name=email]').val(email);
			   $('[name=phone]').val(phone);
			
			   $('#exampleModal').modal('show');
			   $('[name=submit]').attr('onclick','modifyCustomer()');
			   
		}
		
		
		/* addCustomer 펑션을 만들고 input type에 들어있는 값들을 콘솔 또는 alert이용해서 띄워보기 */
		
		function addCustomer(){
			
			/* 값 가져오는방법 : 제이쿼리 alert( $('[name=name]').val() ); */
			
			/* ajzs통신 이용해서 insert.cu를 만들고 해당하는 서블릿까지 값을 전송해보기 */
			var gender = $('[name=gender]:checked').val();
			
			$.ajax({
				url : 'insert.cu',
				data : {	//request.getParameter로 받아줄 것 (name)
					   
					   name:$('[name=name]').val(),
					   gender:gender,
					   email:$('[name=email]').val(),
					   phone:$('[name=phone]').val()
					   
						},	 
				success : function(response){
					/* 페이지 전환이 아니라 out 객체를 통해서 값을 바로 써주면 그 값을 가지고옴 */
					   $('[name=name]').val('')
					   $('[name=gender]').val('')
					   $('[name=email]').val('')
					   $('[name=phone]').val('')
					
				}, error: function(req, msg){
					alert(msg + " : ");
				}	   
			});
			
			//모달창 닫기
		   location.reload();
			$('#exampleModal').modal('hide');
			
		}
		
		function modifyCustomer(){
			var gender = $('[name=gender]:checked').val();
			$.ajax({
				url : 'update.cu',
				data : {	
					   id: $('[name=id]').val(),
					   name:$('[name=name]').val(),
					   gender: gender,
					   email:$('[name=email]').val(),
					   phone:$('[name=phone]').val()
					   
						},	 
				success : function(response){
					alert(response);
					   $('[name=name]').val('');
					   $('[name=gender]').val('');
					   $('[name=email]').val('');
					   $('[name=phone]').val('');
					
				}, error: function(req, msg){
					alert(msg + " : ");
				}	   
			});
			
			//모달창 닫기
		   location.reload();
			$('#exampleModal').modal('hide');
		}
	</script>
	
</body>
</html>1