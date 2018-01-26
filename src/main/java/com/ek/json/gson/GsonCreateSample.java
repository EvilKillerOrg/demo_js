package com.ek.json.gson;

import java.lang.reflect.Field;
import java.util.Date;

import com.ek.json.bean.DiaoSiBean;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonCreateSample {

	public static void main(String[] args) {
		
		DiaoSiBean xiaoer = new DiaoSiBean();
		xiaoer.setName("小二");
		xiaoer.setAge(22.2);
		xiaoer.setBirthday(new Date());
		xiaoer.setSchool("蓝翔");
		xiaoer.setMajor(new String[] { "理发", "挖土" });
		xiaoer.setGirl_friend(false);
		xiaoer.setCar(null);
		xiaoer.setComment("这是一个注释");
		xiaoer.setIgnore("GSON忽略解析这个属性");
		
		

		/* 使用GSON来解析 */
		Gson gson1 = new Gson();
		System.out.println(gson1.toJson(xiaoer));

		
		
		/* 使用GsonBuilder来构建 */
		GsonBuilder gsonBuilder = new GsonBuilder();
		// 输出的时候美化一下
		gsonBuilder.setPrettyPrinting();
		// 返回的时候做一些策略,比如修改返回的key
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() { // 传入一个回调函数
			@Override
			public String translateName(Field f) {
				if ("school".equals(f.getName())) {
					return "MySchool";
				}
				return f.getName();
			}
		});
		Gson gson2 = gsonBuilder.create();
		System.out.println(gson2.toJson(xiaoer));
	}

}
