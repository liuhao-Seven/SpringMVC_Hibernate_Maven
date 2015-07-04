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
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path%>/bootstrap-3.3.4-dist/css/bootstrap.css"
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
				<form class="form-inline" id="fileUpload"
					action="<%=path%>/excel.do" enctype="multipart/form-data"
					target="uploadf" method="post">
					<div class="control-group">
						<label class="control-label">上传文件:</label>
						<div class="controls">
							<input id="excelFile" name="myfile" type="file"
								onchange="$('#text').val(this.value);" style="display: none" />
							<input type="text" class="form-control" id="text"
								name="txtFakeText" readonly="readonly"
								style="width: 350px; margin-bottom: 5px;" /> <input
								type="button" class="btn btn-default"
								onclick="$('#excelFile').click();" value="上传文件" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">上传进度:</label>
						<div class="controls">
							<div class="progress progress-success progress-striped"
								style="width: 50%; margin-top: 5px;">
								<div id='proBar' class="progress-bar progress-bar-success"
									style="width: 0%"></div>
							</div>
						</div>
					</div>
					<div class="control-group">
						<button type="button" id="subbut" class="btn btn-default"
							onclick="submitExcel()">提交</button>
					</div>
				</form> <br /> <iframe name="uploadf" style="display: none"></iframe>
				<div id="example" class="modal fade">
					<div class="modal-dialog" style="width: 500px;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">消息</h4>
							</div>
							<div class="modal-body">
								<p id="modal_text"></p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
							</div>
						</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
var intId;
function submitExcel() {
// 	var excelFile = $("#excelFile").val();
// 	if (excelFile == '') {
// 		alert("请选择需上传的文件!");
// 		return false;
// 	}
// 	if (excelFile.indexOf('.xls') == -1) {
// 		alert("文件格式不正确，请选择正确的Excel文件(后缀名.xls)！");
// 		return false;
// 	}
	$("#fileUpload").submit();
	intId = window.setInterval("eventFun()",100);
}

/*进度查询  */
function eventFun(){
	$.ajax({
		type: 'post',
		url: '<%=path%>/process.do',
		data : {},
		dataType : 'json',
		success : function(data) {
			$('#proBar').css('width', data.rate + '' + '%');
			$('#proBar').empty();
			$('#proBar').append(data.show);
			/* 进度为100%或者出错则退出进度 */
			if (data.rate == 100 ) {
				window.clearInterval(intId);
				$('#modal_text').text("上传成功");
				$('#example').modal('show');
			}else if(data.isfalse == true){
				window.clearInterval(intId);
				$('#modal_text').text("上传失败");
				$('#example').modal('show');
			}
		},
		error : function(){
			window.clearInterval(intId);
			$('#modal_text').text("上传失败");
			$('#example').modal('show');
		}
	});
}
</script>
</html>