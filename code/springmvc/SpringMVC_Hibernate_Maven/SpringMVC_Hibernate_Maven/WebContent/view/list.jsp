<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<style type="text/css">

.td{
	border: 1px #ccc solid;
}
.th{
	background-color: #sss;
}
</style>

</head>
<body>
	<table align="center">
		<tr>
			<th class="th">userName</th>
			<th class="th">password</th>
			<th class="th">age</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td class="td">${user.userName}</td>
				<td class="td">${user.password}</td>
				<td class="td">${user.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>