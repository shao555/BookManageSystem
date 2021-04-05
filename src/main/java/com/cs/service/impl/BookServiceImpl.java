package com.cs.service.impl;

import com.cs.entity.Book;
import com.cs.mapper.BookMapper;
import com.cs.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-03-15 09:50
 */

@Component
@Service("bservice")
public class BookServiceImpl implements BookService {
	
	@Resource
	private BookMapper bookMapper;
	
	//添加图书信息
	@Override
	public int addBook(Book book) throws Exception {
		return bookMapper.addBook(book);
//		return 0;
	}
	
	//删除一本图书信息
	@Override
	public int delBook(int book_ID) throws Exception {
		return bookMapper.delBook(book_ID);
//		return 0;
	}
	
	//修改图书信息
	@Override
	public int updateBook(Book book) throws Exception {
		return bookMapper.updateBook(book);
//		return 0;
	}
	
	//查询所有图书信息
	@Override
	public List<Book> findAllBooks() throws Exception {
		return bookMapper.findAllBooks();
//		return null;
	}
	
	//根据id查询图书
	@Override
	public Book findByID(int book_ID) throws Exception {
		return bookMapper.findByID(book_ID);
//		return null;
	}
	
	//查询可借图书数量
	@Override
	public int findBookCount() throws Exception {
		return bookMapper.findBookCount();
//		return 0;
	}
	
	//根据书名模糊查询可借图书
	@Override
	public List<Book> findByBookName(String book_Name) throws Exception {
		return bookMapper.findByBookName(book_Name);
//		return null;
	}
	
	@Override
	public List<Book> findByLendedBName(String book_Name) throws Exception {
		return bookMapper.findByLendedBName(book_Name);
//		return null;
	}
	
	//根据书名查询可借图书数量
	@Override
	public int findCountByBook_Name(String book_Name) throws Exception {
		return bookMapper.findCountByBook_Name(book_Name);
//		return 0;
	}
	
//	//分页查询
//	@Override
//	public List<Book> getBlist(int start, int count) throws Exception {
//		return bookMapper.getBlist(start, count);
////		return null;
//	}
	
	//分页查询可借图书
	@Override
	public List<Book> findLendableBooks() throws Exception {
		return bookMapper.findLendableBooks();
//		return null;
	}

	//查询已借图书
	@Override
	public int lendBook(int book_ID) throws Exception {
		return bookMapper.lendBook(book_ID);
//		return 0;
	}
	
	//归还图书
	@Override
	public int returnBook(int book_ID) throws Exception {
		return bookMapper.returnBook(book_ID);
//		return 0;
	}
	
	@Override
	public List<Book> findLendedBooks() throws Exception {
		return bookMapper.findLendedBooks();
//		return null;
	}
	
	
}
