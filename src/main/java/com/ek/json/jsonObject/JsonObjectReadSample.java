package com.ek.json.jsonObject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 读取JSON数据(解析json文件) 从外部文件中获取json对象
 * JSONObject不支持从JavaBean解析
 * 
 * @author ek
 *
 */
public class JsonObjectReadSample {
	public static void main(String[] args) throws IOException {
		
		File file = new File(JsonObjectReadSample.class.getResource("../xiaoer.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);

		if (!jsonObject.isNull("name")) { // 判断一下,增加健壮性
			System.out.println("姓名: " + jsonObject.getString("name"));
		}
		if (!jsonObject.isNull("age")) {
			System.out.println("年龄: " + jsonObject.getDouble("age"));
		}
		if (!jsonObject.isNull("girl_friend")) {
			System.out.println("女人: " + jsonObject.getBoolean("girl_friend"));
		}
		if (!jsonObject.isNull("car")) {
			System.out.println("汽车: " + jsonObject.get("car"));
		}
		if (!jsonObject.isNull("major")) {
			// 读取数组:
			JSONArray majorArray = jsonObject.getJSONArray("major"); // 读取
			for (int i = 0; i < majorArray.length(); i++) { // 遍历
				String major = (String) majorArray.get(i);
				System.out.println("专业: " + major);
			}
		}
	}
}
