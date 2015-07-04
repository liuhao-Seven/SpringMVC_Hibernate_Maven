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
<link href="<%=path%>/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
<title>测试</title>
</head>
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.js"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript" src="<%=path%>/bootstrap-3.3.4-dist/js/bootstrap.js"></script>

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
	<table width="90%" align="center" style="margin-top: 100px;">
		<tr>
			<td>
				<form class="form-inline" id="fileUpload" action="<%=path%>/excel.do" enctype="multipart/form-data" method="post">
					<input id="excelFile" name="myfile" type="file" onchange="$('#text').val(this.value);" style="display: none"/> 
					<input type="text" class="form-control" id="text" name="txtFakeText" readonly="readonly"/>
					<input type="button" class="btn btn-default" onclick="$('#excelFile').click();" value="上传文件"/>
					<button type="button" class="btn btn-default" onclick="submitExcel()">提交</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>