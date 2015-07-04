<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试分页</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<style type="text/css">
a{
	border: 1px solid yellow;
	margin: 5px;
}
</style>
</head>
<body>
<div>
	<div>
		用户名:<input id="username" type="text" name="username">
	</div>
	<div>
		年龄:<input id="age" type="text" name="age">
	</div>
	<div>
		<input type="button" value="search" onclick="search('toPage',1);">
	</div>
</div>
<div>
	<div id="userlist" style="height: 242px;border: 1px solid #333;">
	</div>
	<div id="pager">
	</div>
</div>
<script type="text/javascript">
var globalPager;
function showPage(pager){
	//总页数
	var totalPages = pager.totalPages;
	//当前页
	var currentPage = pager.currentPage;
	var html = "<a href=\"javascript:search('toPage','"+(currentPage-1)+"')\"><<</a>";
	if(totalPages <= 5){
		for(var i=1;i<=totalPages;i++){
			html += createPage(i);
		}
	}else{
		if(currentPage<=3 || currentPage >= totalPages-1){
			//12345
			for(var i = 1;i <= 5;i ++){
				html += createPage(i);
			}
		}else if(currentPage < totalPages-2){
			html += createPage(1);
			html += createPage(2);
			html+="...";
			html += createPage(currentPage-1);
			html += createPage(currentPage);
			html += createPage(currentPage+1);
		}else{
			html += createPage(1);
			html += createPage(2);
			html+="...";
			html += createPage(currentPage-2);
			html += createPage(currentPage-1);
			html += createPage(currentPage);
		}
		
		//后面部分
		if(totalPages == 6){
			html+="...";
			html += createPage(6);
		}else{
			html+="...";
			html += createPage(pager.totalPages-1);
			html += createPage(pager.totalPages);
		}
	}
	
	html += "<a href=\"javascript:search('toPage','"+(currentPage+1)+"')\">>></a>";
	html += "  共【"+totalPages+"】页";
	html += " 当前第【"+currentPage+"】页";
	html +="<input type='text' id='toPage' style='width: 20px;'> <a href=\"javascript:search('toPage',$('#toPage').val());\">Go</>";
	$("#pager").html(html);
}

/**
 * 创建每个跳转按钮
 */
function createPage(toPage){
	var html = "<a href=\"javascript:search('toPage','"+toPage+"')\">"+toPage+"</a>";
	return html;
}


/*
 * action:跳转动作(previous,next,first,last,toPage)
 * toPage:要跳转的页数,只有action为toPage时有效
 */
function search(action,toPage){
	var queryData = new Object();
	queryData.username = $('#username').val();
	queryData.age = $('#age').val();
	var pager = new Object();
	pager.queryData =JSON.stringify(queryData);
	//更多信息请参考jquery_api中的ajax请求中对各个参数的说明
	$.ajax({
		async : false,		
//(默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
		type : "POST",		
//请求方式为POST
		url : "searchForList.do?action="+action+"&toPage="+toPage,		
//请求的路径
		data : pager,	
//发送到服务器的数据。将自动转换为请求字符串格式。GET 请求中将附加在 URL 后。查看 processData 选项说明以禁止此自动转换。必须为 Key/Value 格式。如果为数组，jQuery 将自动为不同值对应同一个名称。如 {foo:["bar1", "bar2"]} 转换为 "&foo=bar1&foo=bar2"。
		dataType : 'json',
// 		预期服务器返回的数据类型。如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断，比如XML MIME类型就被识别为XML。在1.4中，JSON就会生成一个JavaScript对象，而script则会执行这个脚本。随后服务器端返回的数据会根据这个值解析后，传递给回调函数。可用值:
// 			"xml": 返回 XML 文档，可用 jQuery 处理。
// 			"html": 返回纯文本 HTML 信息；包含的script标签会在插入dom时执行。
// 			"script": 返回纯文本 JavaScript 代码。不会自动缓存结果。除非设置了"cache"参数。'''注意：'''在远程请求时(不在同一个域下)，所有POST请求都将转为GET请求。(因为将使用DOM的script标签来加载)
// 			"json": 返回 JSON 数据 。
// 			"jsonp": JSONP 格式。使用 JSONP 形式调用函数时，如 "myurl?callback=?" jQuery 将自动替换 ? 为正确的函数名，以执行回调函数。
// 			"text": 返回纯文本字符串
		success : function(data) {
			globalPager = data;
			showData(data);
		},
		error : function(){
			
		}
	});
}

function delUser(userName){
	var url = "deleteUser.do?userName="+userName;
	url = encodeURI(encodeURI(url));
	$.ajax({
		async : false,		
		type : "POST",		
		url : url,
		dataType : 'json',
		success : function() {
			search("toPage",globalPager.currentPage);
		},
		error : function(){
			
		}
	});
}

function showData(pager){
	var div = $('#userlist');
	div.html("");
	//清除数据
//		div.html("wu");
	var table = document.createElement("table");
	var tbody = createTableBody();
	var tr = createTR();
	var td1 = createTD();
	var td2 = createTD();
	var td3 = createTD();
	var td4 = createTD();
	td1.innerHTML = "用户名";
	tr.appendChild(td1);
	td2.innerHTML = "密码";
	tr.appendChild(td2);
	td3.innerHTML = "年龄";
	tr.appendChild(td3);
	td4.innerHTML = "操作";
	tr.appendChild(td4);
	tbody.appendChild(tr);
	for ( var i = 0; i < pager.data.length; i++) {
		if(i>= pager.totalRows){
			break;
		}
		var tr = createTR();
		var data = pager.data[i];
		var td1 = createTD();
		var td2 = createTD();
		var td3 = createTD();
		var td4 = createTD();
		var userName = data.userName;
		userName = cutEmpty(userName);
		td1.innerHTML = userName;
		tr.appendChild(td1);
		
		var password = data.password;
		password = cutEmpty(password);
		td2.innerHTML = password;
		tr.appendChild(td2);
		
		var age = data.age;
		age = cutEmpty(age);
		td3.innerHTML = age;
		tr.appendChild(td3);
		
		td4.innerHTML = "<a href=\"javascript:delUser('"+userName+"',"+pager.currentPage+")\">del</a>";
		tr.appendChild(td4);
		
		tbody.appendChild(tr);
	}
	table.appendChild(tbody);
	div.append(table);
	//设置页码
	showPage(pager);
}
 
/**
 * 判断字符串是否为空
 * 
 * @param value
 * @returns {Boolean}
 */
function isEmpty(value) {
	return (value == undefined || value == null || value == "" || value == "undefined");
}

/**
 * 去空
 * @param value
 */
function cutEmpty(value) {
	return isEmpty(value)? "":value;
}

function createTableBody(){
	var tbody = document.createElement("tbody");
	return tbody;
};
function createTR(){
	var tr = document.createElement("tr");
	return tr;
}
function createTD(){
	var td = document.createElement("td");
	return td;
}
</script>



</body>
</html>