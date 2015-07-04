<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path%>/bootstrap-3.3.4-dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>测试</title>
</head>
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.js"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript"
	src="<%=path%>/bootstrap-3.3.4-dist/js/bootstrap.js"></script>
<body>
	<table width="90%" align="center" style="margin-top: 100px;">
		<tr>
			<td>
				<form id='fForm' class="form-actions form-horizontal"
					action="<%=path%>/excel.do" encType="multipart/form-data"
					target="uploadf" method="post">
					<div class="control-group">
						<label class="control-label">上传文件:</label>
						<div class="controls">
							<input type="file" name="myfile" style="width: 550">
						</div>
						<label class="control-label">上传进度:</label>
						<div class="controls">
							<div class="progress progress-success progress-striped"
								style="width: 50%">
								<div id='proBar' class="progress-bar progress-bar-success" style="width: 0%;height: 34px;"></div>
							</div>
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<button type="button" id="subbut" class="btn btn-default">submit</button>
						</div>
					</div>
				</form> <iframe name="uploadf" style="display: none"></iframe>
			</td>
		</tr>
	</table>
</body>
<script>
	var intId;
	function eventFun(){
		$.ajax({
			type: 'post',
			url: '<%=path%>/process.do',
			data: {},
			dataType: 'json',
			success : function(data){
				$('#proBar').css('width',data.rate+''+'%');
				$('#proBar').empty();
	    		$('#proBar').append(data.show);	
	    		if(data.rate == 100){
	    			window.clearInterval(intId);
	    		}	
		}});
	}
	$(document).ready(function() {
		$('#subbut').bind('click', function() {
			$('#fForm').submit();
			intId = window.setInterval("eventFun()",100);
		});
	});
</script>
</html>
