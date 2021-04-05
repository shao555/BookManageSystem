package com.cs.service.impl;

import com.cs.entity.Admin;
import com.cs.mapper.AdminMapper;
import com.cs.mapper.BookMapper;
import com.cs.service.AdminService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-04-01 16:34
 */

@Component
@Service("aservice")
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper adminMapper;
	
	
	@Override
	public List<Admin> findAllAdmin() throws Exception {
		return adminMapper.findAllAdmin();
//		return null;
	}
	
	@Override
	public Admin login(String admin_Number, String admin_Pwd) throws Exception {
		return adminMapper.login(admin_Number,admin_Pwd);
//		return null;
	}
}
