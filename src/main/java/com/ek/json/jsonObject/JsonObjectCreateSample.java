package com.ek.json.jsonObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.ek.json.bean.DiaoSiBean;

public class JsonObjectCreateSample {

	public static void main(String[] args) {
		CreateJson();
		CreateJsonByMap();
		CreateJsonByBean();
	}

	/* 使用JSONObject构建JSON */
	private static void CreateJson() {
		JSONObject xiaoer = new JSONObject();
		Object isNnll = null;
		xiaoer.put("name", "小二");
		xiaoer.put("age", 22.2);
		xiaoer.put("birthday", "1990-02-02"); // json 没有日期类型,用String代替
		xiaoer.put("school", "蓝翔");
		xiaoer.put("major", new String[] { "理发", "挖土" }); // 可以用数组,也可以用list或set
		xiaoer.put("girl_friend", false);
		xiaoer.put("car", isNnll); // 不能直接放null,因为put方法有两个重载的方法中有null
		xiaoer.put("comment", "这是一个注释"); // json中是没有注释的,用这种方式变通一下

		System.out.println(xiaoer.toString()); // 输出
	}

	/* 使用Map构建JSON(Map转换为JSON,非常方便) */
	private static void CreateJsonByMap() {
		Map<String, Object> xiaoer = new HashMap<String, Object>();
		Object isNnll = null;
		xiaoer.put("name", "小二");
		xiaoer.put("age", 22.2);
		xiaoer.put("birthday", "1990-02-02"); // json 没有日期类型,用String代替
		xiaoer.put("school", "蓝翔");
		xiaoer.put("major", new String[] { "理发", "挖土" }); // 可以用数组,也可以用list
		xiaoer.put("girl_friend", false);
		xiaoer.put("car", isNnll); // 不能直接放null,因为put方法有两个重载的方法中有null
		xiaoer.put("comment", "这是一个注释"); // json中是没有注释的,用这种方式变通一下

		System.out.println(new JSONObject(xiaoer).toString()); // JSONObject的构造器支持传入一个map对象
	}

	/* 使用JavaBean构建JSON(推荐,常用) */
	private static void CreateJsonByBean() {
		DiaoSiBean xiaoer = new DiaoSiBean();
		xiaoer.setName("小二");
		xiaoer.setAge(22.2);
		xiaoer.setBirthday(new Date());
		xiaoer.setSchool("蓝翔");
		xiaoer.setMajor(new String[] { "理发", "挖土" });
		xiaoer.setGirl_friend(false);
		xiaoer.setCar(null);
		xiaoer.setComment("这是一个注释");

		System.out.println(new JSONObject(xiaoer)); // JSONObject的构造器支持传入一个Bean对象
	}
}
