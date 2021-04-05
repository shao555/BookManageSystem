package com.cs.controller;

import com.cs.entity.Admin;
import com.cs.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-04-01 17:09
 */

@Controller
@RequestMapping("/adminc") //Admin Controller
public class AdminController {
	
	@Resource
	AdminService adminService;
	
	@RequestMapping("/alogin.do")
	public ModelAndView login (@RequestParam String admin_Phone,@RequestParam String admin_Pwd) throws Exception{
		ModelAndView modelView = new ModelAndView();
		Admin a = adminService.login(admin_Phone, admin_Pwd);
		if (null != a) {
			modelView.setViewName("forward:/bookc/show");
		}
		return modelView;
	}
	
	
}
