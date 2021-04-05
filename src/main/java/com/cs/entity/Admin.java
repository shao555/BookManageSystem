package com.cs.entity;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-04-01 16:10
 */
public class Admin {
	
	private int admin_ID;
	private String admin_Name;
	private String admin_Number;
	private String admin_Pwd;
	
	public Admin() {
	}
	
	
	public Admin(int admin_ID, String admin_Name, String admin_Number, String admin_Pwd) {
		this.admin_ID = admin_ID;
		this.admin_Name = admin_Name;
		this.admin_Number = admin_Number;
		this.admin_Pwd = admin_Pwd;
	}
	
	public int getAdmin_ID() {
		return admin_ID;
	}
	
	public void setAdmin_ID(int admin_ID) {
		this.admin_ID = admin_ID;
	}
	
	public String getAdmin_Name() {
		return admin_Name;
	}
	
	public void setAdmin_Name(String admin_Name) {
		this.admin_Name = admin_Name;
	}
	
	public String getAdmin_Number() {
		return admin_Number;
	}
	
	public void setAdmin_Number(String admin_Number) {
		this.admin_Number = admin_Number;
	}
	
	public String getAdmin_Pwd() {
		return admin_Pwd;
	}
	
	public void setAdmin_Pwd(String admin_Pwd) {
		this.admin_Pwd = admin_Pwd;
	}
	
	@Override
	public String toString() {
		return "Admin{" +
				"admin_ID=" + admin_ID +
				", admin_Name='" + admin_Name + '\'' +
				", admin_Number='" + admin_Number + '\'' +
				", admin_Pwd='" + admin_Pwd + '\'' +
				'}';
	}
}
