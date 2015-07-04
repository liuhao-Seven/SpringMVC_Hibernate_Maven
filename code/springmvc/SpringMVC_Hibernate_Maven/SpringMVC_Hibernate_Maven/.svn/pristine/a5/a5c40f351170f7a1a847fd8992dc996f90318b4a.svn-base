<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
</head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script>
	function submitExcel() {
		var excelFile = $("#excelFile").val();
		if (excelFile == '') {
			alert("请选择需上传的文件!");
			return false;
		}
		if (excelFile.indexOf('.xls') == -1) {
			alert("文件格式不正确，请选择正确的Excel文件(后缀名.xls)！");
			return false;
		}
		$("#fileUpload").submit();
	}
</script>
<body>
	<form id="fileUpload" action="<%=path%>/excel.do"
		enctype="multipart/form-data" method="post">
		<input id="excelFile" name="myfile" type="file" /> 
		<input type="button" value="提交" onclick="submitExcel()" />
	</form>
</body>
</html>