package com.cs.test;

import com.cs.entity.Book;
import com.cs.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-03-15 09:53
 */


public class BookTest {
	
	
	
	public static void main(String[] args) throws Exception {
	
	
//		delBook(12);
		addBook();
//		updateBook();
	}
	
	//添加书籍信息
	public static void addBook() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		Book book = new Book();
//		book.setBook_ID(9);
		book.setBook_Name("游戏机实用技术第367期");
		book.setBook_Author("游戏机实用技术UCG");
		book.setBook_Publisher("游戏机实用技术杂志社");
		int i = bs.addBook(book);
		if (i > 0) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
	
	//删除一本书籍信息
	public static void delBook(int book_ID) throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		int i = bs.delBook(8);
		if (i > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}
	
	//修改书籍信息
	public static void updateBook() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		Book book = new Book();
		book.setBook_ID(1);
		book.setBook_Name("线性代数");
		book.setBook_Author("华罗庚");
		book.setBook_Publisher("教育部出版社");
		int i = bs.updateBook(book);
		if (i > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}
	
	//查询所有书籍
	@Test
	public void findAllBooks() throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		List<Book> blist = bs.findAllBooks();
		for (Book b : blist) {
			System.out.println(b.getBook_ID() + " " + b.getBook_Name() + " " + b.getBook_Author() + " " + b.getBook_Publisher());
		}
	}
	
	//模糊查询可借图书
	@Test
	public void findByBookName() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		List<Book> blist = bs.findByBookName("我");
		for (Book b : blist) {
			System.out.println(b);
		}
	}
	
	//根据书名查询数量
	@Test
	public void findCountByBook_Name() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		int bCount = bs.findCountByBook_Name("机");
		System.out.println(bCount);
		
		
	}
	
	//根据id查询图书
	@Test
	public void findByID() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		Book book = bs.findByID(1);
		System.out.println(book.toString());
	}
	
	//查询可借图书
	@Test
	public void findLendableBooks() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		List<Book> blist = bs.findLendableBooks();
		for (Book b : blist) {
			System.out.println(b.toString());
		}
		
		
	}
	
	//pagehelper测试
	@Test
	public void pageTest() throws Exception{
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bs = (BookService) act.getBean("service");
		int pageNun = 1; // 页码
		int pageSize = 5;// 每页显示条数
		PageHelper.startPage(pageNun,pageSize);
		
		List<Book> list = bs.findAllBooks();
		PageInfo<Book> page = new PageInfo<Book>(list);
		System.out.println("获取当前页" + page.getPageNum());
		System.out.println("每页显示条数="+page.getPageSize());
		System.out.println("当前页起始行号="+page.getStartRow());
		System.out.println("当前页结束行号="+page.getEndRow());
		System.out.println("总记录数="+page.getTotal());
		System.out.println("总页数="+page.getPages());
		System.out.println("是否为第1页="+page.isIsFirstPage());
		System.out.println("是否为最后1页="+page.isIsLastPage());
		System.out.println("是否有上一页="+page.isHasPreviousPage());
		System.out.println("是否有下一页="+page.isHasNextPage());
		System.out.println("当前页数据=");
		for (Book b : list) {
			System.out.println(b);
		}
		
		
		
		
	}
	
	
}
