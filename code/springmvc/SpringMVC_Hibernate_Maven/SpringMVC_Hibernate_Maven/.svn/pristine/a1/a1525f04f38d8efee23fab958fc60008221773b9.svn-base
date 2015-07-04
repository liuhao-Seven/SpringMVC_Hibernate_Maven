$(function(){
	$(".submit_img").attr("src","../../images/001.png");
	$(".get_policy_img").attr("src","../../images/002.png");
	$(".close_img").attr("src","../../images/8_1.png");
	$(".tex_img").attr("src","../../images/1.png");
	
	/*************弹窗**************/
	$(".get").click(function(){
		/*$(".showbg").show();
		$("body").css("background-color","rgba(0,0,0,0.3)");*/
		 var bh = $("body").height(); 
		 /*var bw = $("body").width();*/
		 $("#fullbg").css({ 
		 height:bh, 
		 display:"block"
		 }); 
		$(".showbg").show();
		$("input").val("电子保单将发送到您输入的邮箱中");
		$("input").css("color","#CCCCCC");
	 });
	$(".ensure").click(function(){
		$(".showbg,#fullbg").hide(); 
	});
	$(".close").click(function(){
		$(".showbg,#fullbg").hide(); 
	});
	
	/************输入框*************/
	$("input").click(function(){
		$(this).css("color","#353535");
		$(this).val("");
	});
	$("input").blur(function(){
		if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test($(this).val())){
			alert("邮箱错误");
		}else{
			alert("邮箱正确")
		}
		
	});
})