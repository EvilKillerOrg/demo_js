package com.ek.json.gson;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.ek.json.bean.DiaoSiBean;
import com.ek.json.jsonObject.JsonObjectReadSample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonReadSample {
	public static void main(String[] args) throws IOException {
		// 从文件读取JSON
		File file = new File(JsonObjectReadSample.class.getResource("../xiaoer.json").getFile());
		String content = FileUtils.readFileToString(file);

		Gson gson1 = new Gson();
		DiaoSiBean xiaoer1 = gson1.fromJson(content, DiaoSiBean.class);
		System.out.println(xiaoer1); // 要打印在DiaoSiBean里加上toString

		// 要处理Date类型的字段的话要用GsonBuilder
		Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		DiaoSiBean xiaoer2 = gson2.fromJson(content, DiaoSiBean.class);
		System.out.println(xiaoer2.getBirthday().toLocaleString()); // 要打印在DiaoSiBean里加上toString
		// 测试一下解析List
		System.out.println(xiaoer2.getMajorList()); // 直接就可以解析和数组一样,set也一样
		System.out.println(xiaoer2.getMajorList().getClass());
	}
}
