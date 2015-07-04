package com.lh.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 基础对象
 * @author 刘浩
 * @date 2014-7-8
 *
 */
public class BaseBean extends Object{
	private String isUsed = "1";		//是否有效		0:无效;1:有效

	public BaseBean(){}
	
	public BaseBean(String isUsed){
		if (isUsed!= null && "0".equals(isUsed.trim())) {
			this.isUsed = "0";
		}else{
			this.isUsed = "1";
		}
	}
	public String getIsUsed() {
		return isUsed;
	}
	
	/**
	 * 设置是否有效
	 * 1：有效  0：无效
	 * 其他值  默认置换 为1
	 * @param isUsed
	 * @date 2014-9-29
	 * @author 刘浩
	 */
	public void setIsUsed(String isUsed) {
		if (isUsed!= null && "0".equals(isUsed.trim())) {
			this.isUsed = "0";
		}else{
			this.isUsed = "1";
		}
	}
	
	public String toString(Object obj){
		try {
			Class<?> clazz = (Class<?>) obj.getClass();
			System.out.println("【类"+clazz+"】toString 开始======================");
			// 得到类中的所有属性集合
			Field[] fs = clazz.getDeclaredFields ();
			for ( int i = 0 ; i < fs. length ; i++){
				Field f = fs[i];
				f.setAccessible( true ); // 设置些属性是可以访问的
				Object val = f.get(obj); // 得到此属性的值
				String type = f.getType().toString(); // 得到此属性的类型
				System.out.println("\tname:"+f.getName()+
						"\t value= " +val+
						"\t type:" + type);
			}
			System.out.println();
			//得到类中的方法
		    Method[] methods = clazz.getMethods();
		    for(int i = 0;i < methods.length;i++){
		    	Method method = methods[i];
		    	if (method.getName().startsWith("get")){
		    		System.out.println("\tmethodName:" +method.getName()+ 
		    				"\t value:"+method.invoke(obj));// 得到 get 方法的值
		    	}
		    }
		    System.out.println("【类"+clazz+"】toString 结束======================");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.toString();
	}
}
