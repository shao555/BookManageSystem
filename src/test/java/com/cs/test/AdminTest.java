package com.cs.test;

import com.cs.entity.Admin;
import com.cs.service.AdminService;
import com.cs.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-04-01 16:42
 */
public class AdminTest {
	
	
	//查询所有管理员
	@Test
	public void findAllAdmin() throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService as = (AdminService) act.getBean("aservice");
		List<Admin> alist = as.findAllAdmin();
		System.out.println(alist);
		
	}
	
	
	//登录
	@Test
	public void login() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService as = (AdminService) act.getBean("aservice");
		String admin_Number = "1145141919810";
		String admin_Pwd = "114514";
	 	Admin a = as.login(admin_Number, admin_Pwd);
		System.out.println(a);
		
	}
	
	
	
	
}