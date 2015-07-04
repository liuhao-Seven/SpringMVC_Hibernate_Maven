$(function(){
	$("#cancel").click(function(){
		$("#dialog").fadeOut();
		$("#dialogcontent").fadeOut();
	})
	$("#shuiyou").click(function(){
		$("#dialog").fadeIn();
		$("#dialogcontent").fadeIn();
		return false;
	})
	$('body').everyTime('40cs','B',function(){
         var num=parseInt(Math.random()*24)*100
         $(".price span").slideUp(200);
         $(".price span").html(num);
          $(".price span").slideDown(200);
         },5);
     $('body').oneTime('21ds',function(){
     	
     	var val=$("input[name=price]").val();
     	$(".price.value").html(val);
       
    });
})
