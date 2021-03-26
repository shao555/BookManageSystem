package com.cs.service;

import com.cs.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-03-15 09:42
 */
public interface BookService {
	
	//添加图书信息
	public int addBook(Book book) throws Exception;
	
	//删除一本图书信息
	public int delBook(int book_ID) throws Exception;
	
	//修改图书信息
	public int updateBook(Book book) throws Exception;
	
	//查询所有图书信息
	public List<Book> findAllBooks() throws Exception;
	
	//根据id查询图书
	public Book findByID(int book_ID) throws Exception;
	
	//查询图书数量
	public int findBookCount() throws Exception;
	
	//根据书名模糊查询可借图书
	public List<Book> findByBookName(@Param("book_Name") String book_Name) throws Exception;
	
	//根据书名查询可借图书数量
	public int findCountByBook_Name(String book_Name) throws Exception;
	
//	//分页查询
//	public List<Book> getBlist(int start, int count) throws Exception;
	
	//分页查询可借图书信息
	public List<Book> findLendableBooks() throws Exception;
	
}
