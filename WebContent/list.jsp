<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.EmaillistVo" %>    

<%
    List<EmaillistVo> list=(List<EmaillistVo>)request.getAttribute("list");//list라는 곳에 있는 내용을 가져옴,(List<EmaillistVo>)는 이러한 형태로 형을 변환 시킴
    

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메일 리스트에 가입되었습니다.</h1>
	<p>입력한 정보 내역입니다.</p>
	<!-- 메일정보 리스트 -->
	<%-- list에서 하나씩 빼서 테이블를 채운다--%>
	<%
	   for(EmaillistVo vo : list){
	
	%>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td align=right width="110">Last name: </td>
			<td width="170"><%=vo.getLastName() %></td>
		</tr>
		<tr>
			<td align=right >First name: </td>
			<td><%=vo.getFirstName() %></td>
		</tr>
		<tr>
			<td align=right>Email address: </td>
			<td><%=vo.getEmail() %></td>
		</tr>
	</table>
	<br>
	<%
	   }
	%>
	
	<p>
		<a href="">추가메일 등록</a>
	</p>
	<br>
</body>
</html>