<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
function getJson(){
	var result = null;
	var sendData = {
		"name":"tom",
		"password":"111111"
	};
	$.ajax({
		async : false,
		type : "POST",
		url : "<%=path%>/getJson.do",
		data : sendData,
		dataType : 'json',
		success : function(data) {
			alert("success");
		}
	});
}


</script>
<body>
	<input type="button" value="测试" onclick="getJson();"/>
</body>
</html>