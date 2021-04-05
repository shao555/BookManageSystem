package com.cs.mapper;

import com.cs.entity.Admin;
import com.cs.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-04-01 16:33
 */
public interface AdminMapper {
	
	//查询所有管理员信息
	public List<Admin> findAllAdmin() throws Exception;
	
	//管理员登录
	public Admin login(@Param("admin_Number") String admin_Number,@Param("admin_Pwd") String admin_Pwd) throws Exception;
	
	
}


