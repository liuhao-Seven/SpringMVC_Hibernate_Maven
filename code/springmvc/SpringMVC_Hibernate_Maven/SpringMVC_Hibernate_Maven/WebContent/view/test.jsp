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
<title>Insert title here</title>
<link href="<%=path%>/bootstrap-3.3.4-dist/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
 <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand"href="#">即刻</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav" id="mytable">
                    <li class="active" role="presentation" class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">文件上传下载
                    <span class="caret"></span></a>
                     <ul class="dropdown-menu" role="menu">
                         <li role="presentation"><a href="" role="menuitem" tabindex="-1">文件上传</a></li>
                         <li role="presentation"><a href="" role="menuitem" tabindex="-1">文件下载</a></li>
                     </ul>
                    </li>
                    <li class=""><a href="#">第二项</a></li>
                    <li class=""><a href="#">第三项</a></li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索"/>
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading">
                文件上传
            </div>
            <div class="panel-body">
                <!-- <form  role="form" enctype="multipart/form-data" id="fileform-01" action="upload.shtml" Method="post"> -->
                    <div class="form-group">
                        <input id="file" name="file" type="file" class="btn btn-default">
                    </div>
                    <button type="button" class="btn btn-default" onclick="ajaxFileUpload('file')">上传</button>
               <!--  </form> -->
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                		<a href="download.shtml" class="btn">文件下载</a>
            </div>
        </div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"  data-keyboard="false" data-backdrop="static">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-body">
		         		<div id="progress" class="progress progress-striped active"  >
  							 <div id="bars" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100">
      						 0%
                       		 </div>
						</div>
		     	 </div>
		      </div>
		</div>
      </div>
      
      <div class="modal fade" id="myModal01" tabindex="-1" role="dialog"  data-keyboard="false" data-backdrop="static">
		   <div class="modal-dialog">
		      <div class="modal-content">
		      	 <div class="modal-header">
            		<h4 class="modal-title" id="myModalLabel">
              			 消息提示
           			</h4>
         		 </div>
		         <div class="modal-body">
						<div id="msg">
							
						</div>
		     	 </div>
		     	 <div id="closebtn" class="modal-footer">
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭
		            </button>
         		</div>
		      </div>
		</div>
      </div>
    </div>

</body>
</html>