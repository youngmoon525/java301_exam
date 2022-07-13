<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!-- JSTL 태그를 이용하기 위한 준비 ↑  -->  
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#new_btn{
		position:fixed;
		right: 20%;
		top: 20%;
		z-index: 999;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script href="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
		<h1>고객관리 모듈(JSTL)</h1>
		<button type="button" id="new_btn" class="btn btn-primary" onclick="showModalInsert();">신규 고객 추가</button>
		
		<table class="styled-table">
		<thead>
			<tr>
				<th>id</th>
				<th>이름</th>
				<th>성별</th>
				<th>이메일</th>
				<th>phone</th>
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
				<button type="button"  class="btn btn-secondary" onclick="showModal('${dto.id}','${dto.name}','${dto.gender}','${dto.email}','${dto.phone}');">정보 수정</button>
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
            <label for="recipient-name" class="col-form-label">이름</label>
            <input type="text" name="name" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">성별</label>
            <input type="radio" name="gender" value="남" checked/>남
            <input type="radio" name="gender" value="여" />여
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이메일</label>
            <input type="text" name="email" class="form-control" id="email">
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">핸드폰</label>
            <input type="text" name="phone" class="form-control" id="phone">
          </div>
      </div>
           <input type="hidden" name="id"> <!-- ajax를 통해서 전송하기 위한 태그 -->
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫귀</button>
        <button type="button" class="btn btn-primary" name="submit" onclick="addCustomer();">추가</button>
      </div>
    </div>
  </div>
</div>
	<%@ include file="/include/footer.jsp"%>
	<script type="text/javascript">
		function showModalInsert(){
			$('#exampleModal').modal('show');
			$('[name=submit]').attr('onclick','addCustomer()');
		}
		
		function showModal(id,name,gender,email,phone){
			$('[name=submit]').attr('onclick','modifyCustomer()');
			$('[name=name]').val(name);
			$('[name=id]').val(id);
			if(gender == '남'){
					$("input:radio[name=gender]:input[value='남']").attr('checked',true);
			}else{
					$("input:radio[name=gender]:input[value='여']").attr('checked',true);
				}
						
			
			$('[name=email]').val(email);
			$('[name=phone]').val(phone);
			
			$('#exampleModal').modal('show');
		}
		function addCustomer(){
			var gender = $('[name=gender]:checked').val();
			$.ajax({
				url:'insert.cu',
				data : {
					name:$('[name=name]').val(),
					gender:gender,
					email:$('[name=email]').val(),
					phone:$('[name=phone]').val()
					},
					success: function(response){
						/* 페이지 전환이 아니라 out객체를 통해서 값을 바로 써주면 그 값을 가지고 옴 */
						$('[name=name]').val(''),
						$('[name=gender]').val(''),
						$('[name=email]').val(''),
						$('[name=phone]').val('')
					},error:function(req,text){
						alert(text +":");
					}
			});
			location.reload();
			$('#exampleModal').modal('hide');
		}
		
		function modifyCustomer(){
			var gender = $('[name=gender]:checked').val();
			$.ajax({
				url:'update.cu',
				data : {
					id:$('[name=id]').val(),
					name:$('[name=name]').val(),
					gender:gender,
					email:$('[name=email]').val(),
					phone:$('[name=phone]').val()
					},
					success: function(response){
						alert(response);
						/* 페이지 전환이 아니라 out객체를 통해서 값을 바로 써주면 그 값을 가지고 옴 */
						$('[name=name]').val(''),
						$('[name=gender]').val(''),
						$('[name=email]').val(''),
						$('[name=phone]').val('')
					},error:function(req,text){
						alert(text +":");
					}
			});
			location.reload();
			$('#exampleModal').modal('hide');
		}
	</script>
</body>
</html>