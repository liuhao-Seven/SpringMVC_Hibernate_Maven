package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lh.util.page.PagerThree;
import com.mvc.domain.SY_INDIVIDUAL_INSURE;

public class GetJson {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		GetJson getJson = new GetJson();
		List<SY_INDIVIDUAL_INSURE> list = new ArrayList<SY_INDIVIDUAL_INSURE>();
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		list.add(getJson.getInsure());
		PagerThree<SY_INDIVIDUAL_INSURE> pager = new PagerThree<SY_INDIVIDUAL_INSURE>();
		pager.setData(list);
		System.out.println(gson.toJson(pager));
	
	}
	
	public SY_INDIVIDUAL_INSURE getInsure(){
		SY_INDIVIDUAL_INSURE insure = new SY_INDIVIDUAL_INSURE();
		insure.setName("张三");
		insure.setSex("1");//1：男；2：女
		insure.setIdType("1");//1:身份证
		insure.setId("000000000000000000");
		insure.setEmployeeId("0000001");
		insure.setOrgCode("00000");
		insure.setOrgName("创昱达");
		insure.setDeptName("开发一部");
		insure.setDeptNo("001");
		insure.setBthDate(new Date());
		insure.setCouName("中国");
		insure.setMobile("18300000000");
		insure.setEmail("abc@163.com");
		insure.setFtele("0513-00000000");
		insure.setAccountAddr("上海市");
		insure.setZipCode("200000");
		insure.setClassCode("190920");//险种代码
		insure.setClassName("分红 ");//险种名称
		insure.setTaxAmount(2400);//递延税额  0<taxamount<=6000
		insure.setPayMentAmount(8000);
		insure.setPayCode("13");//缴费方式代码: 13～年缴 
		insure.setBankCode("01910");
		insure.setBankName("招商银行");
		insure.setAccouno("60200000000000000");
		insure.setAccname("张三");
		insure.setStatus("1");//数据投保状态：1确认投保-新增 2.确认投保-正常 3.确认投保-递税修改,4.确认投保-保费修改 5.不投保,6.待确认投保,7.删除}
		insure.setCre_date("2015-06-24 16:57:30");
		insure.setReview_status("0");//数据复核情况：0初始状态  1待复核 2已复核通过 (默认0)
		insure.setIfUnload("0");//是否导给FF(0.未导入 1.导入中 2.导入出错 3.出错修改中(重新投保) 5.导入成功)
//		insure.setAppNo("");
//		insure.setIssue("");//批导FF:{错误类型}
//		insure.setVerifyInfo("");//--批导FF:{校验错误代码}
		insure.setFf_loadDate(null);//--批导FF:{导给FF的时间}
		return  insure;
	}
}