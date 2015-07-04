/**
 * 
 * 注：
 * component提供的遮罩定义的控件id为ScreenMask，使用时请避免页面占用该id
 * component提供的消息框定义的控件id为winMesbox，使用时请避免页面占用该id
 */
function component(){
	/**
	 * 创建一个固定在底部的有遮罩的面板
	 * @param options 创建面板所需的参数
	 * 		   showCancelBtn 是否显示取消按钮（默认false）
	 * 		   showOkBtn 是否显示完成按钮（默认false）
	 * 		   okHandler 完成按钮的点击事件处理方法
	 * 		   id 此面板的id（唯一）
	 * 		   html 在面板中显示的html代码
	 */
	this.createPanel=function(options){
		var div = document.createElement("div");
		div.setAttribute("class", "component-panel-content");
		var html = options.html;
		if(options.showCancelBtn == true || options.showOkBtn == true){
			var btnsDiv = "<div class=\"component-panel-btn\">";
			if(options.showCancelBtn == true){
				btnsDiv += "<span class=\"component-panel-btn-left\" onclick=\"component.hidePanel('"+options.id+"')\">取&nbsp;消</span>";
			};
			if(options.showOkBtn == true){
				btnsDiv += "<span class=\"component-panel-btn-right\" onclick=\""+options.okHandler+"\">完&nbsp;成</span>";
			}
			btnsDiv += "</div>";
			html = btnsDiv+html;
		}
		div.innerHTML = html;
		div.id = options.id;
		document.body.appendChild(div);
	};
	/**
	 * 显示面板
	 * @param panelId 面板id
	 */
	this.showPanel=function(panelId){
		Tools.showMask(50,false);
		$("#"+panelId).css("display","block");
	};

	/**
	 * 隐藏面板
	 * @param panelId 面板id
	 */
	this.hidePanel=function(panelId){
		Tools.hideMask();
		$("#"+panelId).css("display","none");
	};

	/**
	 * 添加遮罩
	 * @param opacity 不透明度
	 * @param goTop 是否需要回到顶部
	 */
	this.showMask = function(opacity,goTop){
		var ScreenOver = document.getElementById("ScreenMask");
		if(ScreenOver != null){
			return;
		}
		if(!opacity){
			opacity = 50;
		}
		var objScreen = document.createElement("div");
		var oS = objScreen.style;
		objScreen.id = "ScreenMask";
		oS.display = "block";
		oS.top = oS.left = oS.margin = oS.padding = "0px";
		oS.width = "100%";
		var height = document.body.scrollHeight;
		oS.height = height+"px";
		oS.position = "absolute";
		oS.zIndex = "999";
		oS.background = "#000000";
		oS.filter = "alpha(opacity="+opacity+")";
		oS.opacity = opacity / 100;
		oS.MozOpacity = opacity / 100;
		document.body.appendChild(objScreen);
		
		if(goTop == true){
			$('html,body').animate({
			scrollTop : '0px'
			}, 100);//因为页面很长，有纵向滚动条，先让页面滚动到最顶端，然后禁止滑动事件，这样可以使遮罩层锁住整个屏幕
		}
		$('#ScreenMask').bind("touchmove", function(e) {
			e.preventDefault();
		});
	};
	/**
	 * 隐藏遮罩
	 */
	this.hideMask = function(){
		var ScreenOver = document.getElementById("ScreenMask");
		if(ScreenOver){
			document.body.removeChild(ScreenOver);
		}
	};

	/**
	 * 显示消息框
	 * @param msg 要显示的消息
	 * @param btnTexts 按钮文本数组
	 * @param btnHandler 按钮点击事件处理方法（该方法的参数表示点击的按钮序号，从0开始）
	 */
	this.showMessagebox = function(msg,btnTexts,btnHandler,data){
		var divMain = document.getElementById("winMesbox");
		if(!divMain){
			divMain = document.createElement("div");
			divMain.id="winMesbox";
			divMain.setAttribute("class", "component-messagebox-win");
		}else{
			divMain.innerHTML = "";
		}
		
		
		var divMsg = document.createElement("div");
		
		divMsg.setAttribute("class", "component-messagebox-msg");
		this.messageBtnHandler = btnHandler;
		
		msg = "<div class='component-messagebox-title'>提示</div>" + msg;
		divMsg.innerHTML = msg;
		divMain.appendChild(divMsg);
		
		$(divMain).bind("touchmove", function(e) {
			e.preventDefault();
		});
		
		
		var divBtnContainer = document.createElement("div");
		divBtnContainer.setAttribute("class", "component-messagebox-btnContainer");
		
		for ( var i = 0; i < btnTexts.length; i++) {
			var divBtn = document.createElement("div");
			divBtn.setAttribute("class", "component-messagebox-btn");
			divBtn.innerHTML = btnTexts[i];
			divBtn.id="messageBtn"+i;
			$(divBtn).bind("click", { index: i,data:data }, this.hideMessagebox);
			divBtnContainer.appendChild(divBtn);
		}
		
		divMain.appendChild(divBtnContainer);
		
//		if(btnTexts.length == 1){
//			var divBtn = document.createElement("div");
//			divBtn.setAttribute("class", "component-messagebox-btn");
//			divBtn.innerHTML = btnTexts[0];
//			divBtn.id="messageBtn0";
//			$(divBtn).bind("click", { index: 0,data:data }, this.hideMessagebox);
//			divMain.appendChild(divBtn);
//		}else{
//			for ( var i = 0; i < btnTexts.length; i++) {
//				var divBtn = document.createElement("div");
//				divBtn.setAttribute("class", "component-messagebox-btns");
//				divBtn.innerHTML = btnTexts[i];
//				divBtn.id="messageBtn"+i;
//				$(divBtn).bind("click", { index: i,data:data }, this.hideMessagebox);
//				divMain.appendChild(divBtn);
//			}
//		}
		this.showMask(50,false);
		document.body.appendChild(divMain);
	};
	this.messageBtnHandler = null;

	/**
	 * 隐藏消息框
	 */
	this.hideMessagebox = function(evt){
		var winMesbox=document.getElementById("winMesbox");
		if(winMesbox){
			document.body.removeChild(winMesbox);
		}
		component.hideMask();
		if(component.messageBtnHandler != null){
			component.messageBtnHandler(evt.data.index,evt.data.data);
		}
		
	};
	
	/**
	 * 创建60秒倒计时按钮
	 * @param id 要创建按钮的div的id
	 * @param handler 判断是否要开始倒计时的函数，需要返回true或false
	 * 
	 */
	this.createValidateDIV=function(id,handler){
		this.validateDIVId = id;
		this.totleTime = 1;
		this.validateDIVHandler = handler;
		$("#"+component.validateDIVId).addClass("component-validateCode-btn");
		this.showTime();
	};
	this.recoverValidateDIV = function(){
		if(component.showTimeHandler){
			clearInterval(component.showTimeHandler);
		}
		if(component.validateDIVId){
			$("#"+component.validateDIVId).html("获取验证码");
			$("#"+component.validateDIVId).css("opacity","1");
			$("#"+component.validateDIVId).bind("click",function(){
				if(component.validateDIVHandler() == true){
					$("#"+component.validateDIVId).css("opacity","0.5");
					component.totleTime = 60;//默认60秒
					$("#"+component.validateDIVId).html(component.totleTime+"秒后重发");
					$("#"+component.validateDIVId).unbind();
					component.showTimeHandler = setInterval("component.showTime()", 1000);
				}
			});
		}
	};
	this.totleTime = 0;//倒计时时间
	this.validateDIVHandler = null;//判断是否要开始倒计时的函数
	this.validateDIVId = null;//要创建按钮的div的id
	this.showTimeHandler = null;
	this.showTime = function() {
		this.totleTime = this.totleTime - 1;
		var num = this.totleTime;
		if(this.totleTime < 10){
			num = "0"+num;
		};
		
		if (component.totleTime == 0) {
			component.recoverValidateDIV();
		} else {
			$("#"+component.validateDIVId).html(num+"秒后重发");
		};
	};
	
	this.currentShowPageId = null;
	this.toShowPageId = null;
	this.initPage = function(){
		var viewportheight=0;
		if (typeof window.innerWidth != 'undefined'){
			viewportheight = window.innerHeight;
		}else if (typeof document.documentElement != 'undefined' && typeof document.documentElement.clientWidth != undefined &&
				 document.documentElement.clientWidth != 0){
			viewportheight = document.documentElement.clientHeight;
		}else{
			viewportheight = document.getElementsByTagName('body')[0].clientHeight;
		}
		
		$("div[data-role='page']").addClass("component-page-container");
//		$("div[data-role='page']").first().css("display","block");
		$("div[data-role='page']").each(function(i){
			$(this).css("display","none");
			$(this).css("z-index","1");
			$(this).css("height",viewportheight+"px");
			if(i == 0){
				$(this).css("display","block");
				$(this).css("z-index","2");
				component.currentShowPageId = $(this).attr("id");
			}
		});
	};
	this.toPage=function(id,type){
		component.toShowPageId = id;
		var viewportWidth=0;
		if (typeof window.innerWidth != 'undefined'){
			viewportWidth = window.innerWidth;
		}else if (typeof document.documentElement != 'undefined' && typeof document.documentElement.clientWidth != undefined &&
				 document.documentElement.clientWidth != 0){
			viewportWidth = document.documentElement.clientWidth;
		}else{
			viewportWidth = document.getElementsByTagName('body')[0].clientWidth;
		}
		$("div[data-role='page']").css("z-index","1");
		$("#"+id).css("z-index","2");
		
		if(type == "back"){
			$("#"+id).css("left","-"+viewportWidth+"px");
		}else{
			$("#"+id).css("left",viewportWidth+"px");
		}
		
		$("#"+id).css("display","block");
		$("#"+id).animate({left:"0px"},"fast",null,component.clearPage).delay(1000);
	};
	
	this.clearPage = function(){
		$("#"+component.currentShowPageId).css("display","none");
		component.currentShowPageId = component.toShowPageId;
	};
	
	
	/**
	 * 
	 * @param relatePath 相对于根目录的路径(如:../../../)
	 * @param selectContaintId 选择框的id 
	 * @param title 标题 
	 * @param dataList 待加载的数据（格式如[{key:value}]） 
	 * @param clickHandler 点击事件，传回参数（item的索引，item的值）
	 * @param backHandler 返回按钮的事件 
	 * 
	 */
	this.createSelectDiv = function(relatePath,selectContaintId,title,dataList,clickHandler,backHandler){
		var contents = document.getElementById(selectContaintId);
		if(!contents){
			contents = document.createElement("div");
		}
		contents.id = selectContaintId;
		contents.style.display = "none";
		var stri = "";
		stri += "<header class='header'>";
		if(backHandler){
			stri += "<img onclick='"+backHandler+"()' class='image middle' src='"+relatePath+"resource/img/mobile/backward.png'/>";
		}else{
			stri += "<span><img src='"+relatePath+"resource/img/mobile/backward.png'/></span>";
		}
		stri += "<span id='headspansex'>"+title+"</span>";
		stri += "</header>";
		
		stri += "<div id=\""+selectContaintId+"-wrapper\" class=\"dht-ScrollPage2\"><section>";
		stri += "<table class='component-select-table'>";
		for(var i = 0; i < dataList.length;i++){
			stri += "<tr onclick=\""+clickHandler+"("+i+",'"+dataList[i].value+"')\">";
			stri +="<td><span>"+dataList[i].label+"</sapn></td></tr>";
		}			
		stri += "</table></section></div>";
		contents.innerHTML = stri;
		document.body.appendChild(contents);
	};
	
	
	this.createSelectAddressDiv = function(relatePath,selectContaintId,title,dataList,clickHandler,backHandler){
		var contents = document.getElementById(selectContaintId);
		if(!contents){
			contents = document.createElement("div");
		}
		contents.id = selectContaintId;
		contents.style.display = "none";
		var stri = "";
		stri += "<header>";
		if(backHandler){
			stri += "<span class='headerimage' onclick='"+backHandler+"()'><img src='"+relatePath+"resource/img/mobile/backward.png'/></span>";
		}else{
			stri += "<span class='headerimage'><img src='"+relatePath+"resource/img/mobile/backward.png'/></span>";
		}
		
		
		stri += "<span id='headspansex'>"+title+"</span>";
		stri += "<span class='headerspan3'>&nbsp;&nbsp;</span></header>";
		stri += "<div id='wrapper"+selectContaintId+"' class='dht-ScrollPage1'>";
		stri += "<section>";
		stri += "<table class='component-select-table'>";
		for(var i = 0; i < dataList.length;i++){
			stri += "<tr onclick=\""+clickHandler+"("+i+",'"+dataList[i].value+"')\">";
			stri +="<td><span>"+dataList[i].label+"</sapn></td></tr>";
		}			
		stri += "</table></section>";
		stri += "</div>";
		contents.innerHTML = stri;
		document.body.appendChild(contents);
	};
	
	/**
	 * 
	 * @param relatePath 相对于根目录的路径(如:../../../)
	 * @param selectContaintId 选择框的id 
	 * @param title 标题 
	 * @param dataList 待加载的数据（格式如[{key:value}]） 
	 * @param clickHandler 点击事件，传回参数（item的索引，item的值）
	 * @param backHandler 返回按钮的事件 
	 * 
	 */
	this.createMultipleSelect = function(relatePath,selectContaintId,title,dataList,clickHandler,backHandler){
		var contents = document.getElementById(selectContaintId);
		if(!contents){
			contents = document.createElement("div");
		}
		contents.id = selectContaintId;
		contents.style.display = "none";
		
		var str = "<header class='header'>";
		if(backHandler){
			str += "<img onclick='"+backHandler+"()' class='image middle' src='"+relatePath+"resource/img/mobile/backward.png'/>";
		}else{
			str += "<span><img src='"+relatePath+"resource/img/mobile/backward.png'/></span>";
		}
		str += "<span>"+title+"</span>";
		str += "</header>";
		str += "<div id=\""+selectContaintId+"-wrapper\" class=\"dht-ScrollPage2\"><section>";
		str += "<ul class=\"component-MultipleSelect-ad_manage_item1\">";
		for ( var i = 0; i < dataList.length; i++) {
			var li = "<li onclick=\"component.multipleSelect(this)\">"
				 + "<div class=\"component-MultipleSelect-item_left1\" data-value='"+dataList[i].value+"'>"+dataList[i].label+"</div>"
				 + "<img class=\"component-MultipleSelect-item_right1\" src=\""+relatePath+"resource/img/mobile/agree.png\">"
			     + "</li>";
			str += li;
		};
		str += "</ul><div class=\"component-MultipleSelect-btm_btn1\" onclick=\""+clickHandler+"()\">确认</div>";
		str += "</section></div>";
		contents.innerHTML = str;
		document.body.appendChild(contents);
	};
	
	this.multipleSelect = function(obj){
		
		var stat = $(obj).find("img").css("display");
		if("none"==stat){
			var aId = $(obj).parent().parent().parent().attr("id");
			var selectLength = $(".component-MultipleSelect-active_item").length;
			if(("focusDiv-wrapper" == aId) && (selectLength >= 3)){
				component.showMessagebox("最多只能选择三个专注领域！",["确定"]);
				return;
			}
			
			$(obj).attr("data-checked","checked");
			$(obj).addClass("component-MultipleSelect-active_item");
			$(obj).find("img").show();
		}else{
			$(obj).attr("data-checked","");
			$(obj).removeClass("component-MultipleSelect-active_item");
			$(obj).find("img").hide();
		}
	};
	
	this.getMultipleSelectValue = function(){
		var label = "";
		var code = "";
		$("[data-checked='checked']").each(function(i){
			label += $(this).find("div").html()+",";
			code += $(this).find("div").attr("data-value")+",";
		});
		if(label.length > 0){
			var temp = label.charAt(label.length-1);
			if(temp == ","){
				label = label.substring(0, label.length-1);
			}
		}
		if(code.length > 0){
			var temp = code.charAt(code.length-1);
			if(temp == ","){
				code = code.substring(0, code.length-1);
			}
		}
		return [label,code];
	};
	
	
	
/*************************************************PC端组件*************************************************/
	
/*************************************分页组件开始*************************************/
	
	/**
	 * 使用方法：
	 * 1. 实例化component对象
	 * 2. 调用createPageNumComponent方法创建分页组件
	 * 3. 每次执行完clickCallBack事件后需手动调用refreshPage方法刷新组件
	 * 
	 * 参考：
	 * 	var c = new component();
	 * 	c.createPageNumComponent("pagenum", 50,"test");
	 * 	function test(number,totalNum){
	 *		c.refreshPage(number, totalNum);
	 *	}
	 * 
	 */
	
	this.pageNumComponentTotal = 0;
	this.pageContainerId;
	this.clickCallBack;
	/**
	 * 创建分页组件
	 * @param pageContainerId 分页组件容器id
	 * @param totalNum 总页数
	 * @param clickCallBack 点击页码的事件名称(该事件包含两个参数[点击的页码，总页数])
	 * 
	 * @param pageContainerId 分页组件
	 */
	this.createPageNumComponent = function(pageContainerId,totalNum,clickCallBack){
		this.pageNumComponentTotal = totalNum;
		this.pageContainerId = pageContainerId;
		this.clickCallBack = clickCallBack;
		
		$("#"+pageContainerId).attr("class","component-pagenum");
		var content = document.createElement("div");
		var str = "<span style='float:left;'><</span>";
		for(var i=1; i<=totalNum; i++){//显示每一个页码
			str += "<span id='"+pageContainerId+"-component-page" + i + "' onclick=\""+clickCallBack+"(" + i + ","+totalNum+")\">" + i + "</span>";
		}
		str +="<span>></span>";
		$(content).html(str);
		$("#"+pageContainerId).html(content);
		$("#"+pageContainerId+"-component-page1").attr("class","component-pagenum-show");
		
		for(var k=1; k<=totalNum-6; k++){
			$("#"+pageContainerId+"-component-page5").html("...");
			$("#"+pageContainerId+"-component-page"+(5+k)).hide();
		}
	};
	
	/**
	 * 刷新分页组件
	 * 
	 * @param number 当前页码
	 * @param totalNum 总页码
	 * 
	 */
	this.refreshPage = function(number,totalNum){
		if(this.pageNumComponentTotal != totalNum){
			this.createPageNumComponent(this.pageContainerId,totalNum,this.clickCallBack);
			this.refreshPage(number,totalNum);
		}
		for(var j=1; j<=totalNum; j++){
			if(j==number){
				$("#"+this.pageContainerId+"-component-page"+j).attr("class","component-pagenum-show");
			}else{
				$("#"+this.pageContainerId+"-component-page"+j).attr("class","");
			};
		}
		for(var k=1; k<=totalNum; k++){
			$("#"+this.pageContainerId+"-component-page"+k).html(k);
		}
		for(var m=-4; m<=4; m++){
			$("#"+this.pageContainerId+"-component-page"+(number+m)).show();
		}
		$("#"+this.pageContainerId+"-component-page"+(number+4)).html("...");
		$("#"+this.pageContainerId+"-component-page"+(number-4)).html("...");
			
		for(var n=5; n<=totalNum; n++){
			$("#"+this.pageContainerId+"-component-page"+(number+n)).hide();
		}
		for(var n=5; n<=totalNum; n++){
			$("#"+this.pageContainerId+"-component-page"+(number-n)).hide();
		}
		$("#"+this.pageContainerId+"-component-page1").show();
		$("#"+this.pageContainerId+"-component-page1").html("1");
		$("#"+this.pageContainerId+"-component-page"+totalNum).show();
		$("#"+this.pageContainerId+"-component-page"+totalNum).html(totalNum);
		
	};
	
/*************************************分页组件结束*************************************/
}


