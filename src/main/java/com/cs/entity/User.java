package com.cs.entity;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-04-05 15:07
 */
public class User {
	
	private int user_ID;
	private String user_Name;
	private String user_Phone;
	private String user_Pwd;
	
	
	public User() {
	}
	
	public User(int user_ID, String user_Name, String user_Phone, String user_Pwd) {
		this.user_ID = user_ID;
		this.user_Name = user_Name;
		this.user_Phone = user_Phone;
		this.user_Pwd = user_Pwd;
	}
	
	public int getUser_ID() {
		return user_ID;
	}
	
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	
	public String getUser_Name() {
		return user_Name;
	}
	
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	
	public String getUser_Phone() {
		return user_Phone;
	}
	
	public void setUser_Phone(String user_Phone) {
		this.user_Phone = user_Phone;
	}
	
	public String getUser_Pwd() {
		return user_Pwd;
	}
	
	public void setUser_Pwd(String user_Pwd) {
		this.user_Pwd = user_Pwd;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"user_ID=" + user_ID +
				", user_Name='" + user_Name + '\'' +
				", user_Phone='" + user_Phone + '\'' +
				", user_Pwd='" + user_Pwd + '\'' +
				'}';
	}
}
