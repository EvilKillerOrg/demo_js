package com.ek.json.bean;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DiaoSiBean {

	/* 测试使用JavaBean 构建JSON时使用到的Bean */

	@SerializedName("last_name") // 这是GSON提供的可以替换key
	private String name;
	private double age;
	private Date birthday;
	private String school;
	private String[] major;
	private boolean girl_friend;
	private Object car;
	private String comment;

	// 使用transient声明一个属性,在使用gson解析的时候可以忽略这个属性,
	private transient String ignore;
	// 测试使用GSON解析List
	private List<String> majorList;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String[] getMajor() {
		return major;
	}

	public void setMajor(String[] major) {
		this.major = major;
	}

	public boolean isGirl_friend() {
		return girl_friend;
	}

	public void setGirl_friend(boolean girl_friend) {
		this.girl_friend = girl_friend;
	}

	public Object getCar() {
		return car;
	}

	public void setCar(Object car) {
		this.car = car;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIgnore() {
		return ignore;
	}

	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}

	public List<String> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<String> majorList) {
		this.majorList = majorList;
	}

	// @Override
	// public String toString() {
	//
	// return "name:" +this.getName() +"age: "+this.getAge();
	// }
}
