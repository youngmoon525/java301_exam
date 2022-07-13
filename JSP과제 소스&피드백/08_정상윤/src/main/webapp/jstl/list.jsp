<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<h1> JSTL 사용</h1>
	<p>JSP 개발을 좀더 편하고 단순화하기 위한 태그 library(JSP Standard Tag Library)</p>
	
	<h3>CORE(jstl/core)</h3>
	<a href="listfmt.js"> 포맷태그</a>	<!-- listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 (Controller)처리 -->
	<% int num= 100; %>
	
	<c:set var="num1" value="200" />
	
	<p>자바로 만든 변수 EL문법으로 출력 : ${num}</p>
	<p>JSTL로 만든 변수 출력 : ${num1 }</p>
	<c:set var="num2" value="300" />
	
	<p>num1과 num2의 합 :  ${num1 + num2} </p>
	
	<!-- Attribute(req)에 들어있는 값을 판단해서 사용을 해야 금방 익숙해짐. -->
	<h1>choose when</h1>
	<c:choose>
		<c:when test="${num1 == 200 }">
			<a>200이 맞습니다 </a>
		</c:when>
		<c:when test="${num1 != 200 }">
			<a>200이 아닙니다 </a>
		</c:when>
	</c:choose>
	
	<h1> 코어 if </h1>
	<c:if test="${num1 == 200 }">
		<p>200이랑 같습니다. if</p>
	</c:if>
	
	
	<!-- ● 데이터가 한건 이상일 경우 Collection 자료구조 에서 Object를 뺄때 유용 -->
	<!-- 초기변수 지정해야함 -->
	<h1>코어 foreach</h1>
	<% for(int i = 0; i <= 10; i++){%>
		<p><%=i %> ← 자바 for문을 이용한 반복문</p>	
		
	<%}%>
	<c:forEach var="i" begin="0" end="10">
		<p>${i } ← EL foreach문을 이용한 반복문</p>	
	
	</c:forEach>
	
	
	<!-- 구구단스 -->
	<table>
	<c:forEach var="i" begin="2" end="9">
		<tr>
		<c:forEach var="j" begin="1" end="9">
		<td><p>${i } X ${j } = ${i*j} </p></td>	
		</c:forEach>
		</tr>
	</c:forEach>
	</table>
	
	
	
	
	
	
	
	
	
</body>
</html>