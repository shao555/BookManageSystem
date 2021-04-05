package com.cs.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cs.entity.Book;
import com.cs.service.impl.BookServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-03-16 15:59
 */

@Controller
@RequestMapping("/bookc") //c  -> Controller
public class BookController {
	
	@Resource
	private BookServiceImpl booService;

//	//查询所有页面
//	@RequestMapping("/show")
//	public String findAll(Model model) throws Exception{
//
//
//		//查询所有书籍信息
//		List<Book> blist = booService.findAllBooks();
//		//查询数量
//		int bCount = booService.findBookCount();
//		model.addAttribute("blist",blist);
//		model.addAttribute("bCount",bCount);
//		return "show";
//	}
	
	
		//跳转主页面
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() throws Exception {
		return "main";
	}
	
//	//查询所有页面 ajax测试
//	@RequestMapping(value = "/show",produces = {"application/json;charset=UTF-8"})
//	@ResponseBody
//	public String findAll(@RequestParam(required = true, defaultValue = "1") Integer page, HttpServletResponse response) throws Exception { //, @RequestParam(required=false,defaultValue="5")Integer pageSize
//		ModelAndView modelView = new ModelAndView();
//
////		response.setCharacterEncoding("utf-8");
////		PrintWriter out = response.getWriter();
//
//		PageHelper.startPage(page, 5);
//
////		JSONObject jsonObject = new JSONObject();
//
//		//查询所有书籍信息
//		List<Book> blist = booService.findLendableBooks();
//
//		PageInfo<Book> pageInfo = new PageInfo<>(blist);
//
//		modelView.addObject("pageInfo", pageInfo);
//
////		Gson gson = new Gson();
////		String json = gson.toJson(blist);
//
//		String bjson = JSON.toJSONString(blist);
//		String pjson = JSON.toJSONString(pageInfo);
//
////		System.out.println(pjson);
////		System.out.println(bjson);
//
////		modelView.addObject("blist", blist);
//		modelView.addObject("bCount", pageInfo.getTotal()); // pageInfo.getTotal()获取总数
////		modelView.setViewName("show");
//
////		return blist;
//
////		return bjson;
//		return pjson;
////		return modelV iew;
//	}

	
	
//	查询所有页面 分页
	@RequestMapping("/show")
	public ModelAndView findAll(@RequestParam(required = true, defaultValue = "1") Integer page) throws Exception { //, @RequestParam(required=false,defaultValue="5")Integer pageSize
		ModelAndView modelView = new ModelAndView();

		PageHelper.startPage(page, 10);

		//查询所有书籍信息
		List<Book> blist = booService.findLendableBooks();

		PageInfo<Book> pageInfo = new PageInfo<>(blist);

		modelView.addObject("pageInfo", pageInfo);


		modelView.addObject("blist", blist);
		modelView.addObject("bCount", pageInfo.getTotal()); // pageInfo.getTotal()获取总数
		modelView.setViewName("show");
		return modelView;
	}
	
	
	//跳转修改图书页面
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateBook(@RequestParam int book_ID,
	                         Model model) throws Exception {
		//根据图书编号查询图书
		Book book = booService.findByID(book_ID);
		model.addAttribute("b", book);
		return "update";
	}

	//do修改图书
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updatedo(HttpServletRequest request) throws Exception {
		ModelAndView modelView = new ModelAndView();
		String book_ID = request.getParameter("book_ID");
		int bookID = Integer.parseInt(book_ID);
		String book_Name = request.getParameter("book_Name");
		String book_Author = request.getParameter("book_Author");
		String book_Publisher = request.getParameter("book_Publisher");
		Book book = new Book();
		book.setBook_ID(bookID);
		book.setBook_Name(book_Name);
		book.setBook_Author(book_Author);
		book.setBook_Publisher(book_Publisher);
		//修改图书信息
		int i = booService.updateBook(book);
		if (i > 0) {
			modelView = this.findAll(1);
//			modelView.setViewName("show");
		}
		return modelView;
	}
	

	//跳转查看图书页面
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String checkBook(@RequestParam int book_ID,
	                        Model model) throws Exception {
		//根据图书编号查询图书
		Book book = booService.findByID(book_ID);
		model.addAttribute("b", book);
		return "checkBook";
	}


	//跳转添加图书页面
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook() throws Exception {
		return "addBook";
	}

	//do添加图书
	@RequestMapping(value = "/addBook.do", method = RequestMethod.GET)
	public ModelAndView addBookdo(HttpServletRequest request) throws Exception {
		ModelAndView modelView = new ModelAndView();
		String book_Name = request.getParameter("book_Name");
		String book_Author = request.getParameter("book_Author");
		String book_Publisher = request.getParameter("book_Publisher");
		Book book = new Book();
		book.setBook_Name(book_Name);
		book.setBook_Author(book_Author);
		book.setBook_Publisher(book_Publisher);
		//添加图书
		int i = booService.addBook(book);
//		String index = "";
		if (i > 0) {
			modelView = this.findAll(1);
		}
		return modelView;
	}


	//do删除图书
	@RequestMapping(value = "/delBook.do", method = RequestMethod.GET)
	public ModelAndView delBookdo(@RequestParam int book_ID) throws Exception {
		ModelAndView modelView = new ModelAndView();
		//删除图书
		int i = booService.delBook(book_ID);
		String index = "";
		if (i > 0) {
			modelView = this.findAll(1);
		}
		return modelView;
	}
	
	//do借阅图书
	@RequestMapping(value = "/lendBook.do", method = RequestMethod.GET)
	public ModelAndView lendBookdo(@RequestParam int book_ID) throws Exception {
		ModelAndView modelView = new ModelAndView();
		//借阅图书
		int i = booService.lendBook(book_ID);

		if (i > 0) {
			modelView = this.findAll(1);
		}
		return modelView;
	}

	//do归还图书
	@RequestMapping(value = "returnBook.do")
	public ModelAndView returnBookdo(@RequestParam int book_ID) throws Exception{
		ModelAndView modelView = new ModelAndView();
		
		//归还图书
		int i = booService.returnBook(book_ID);
		
		if (i > 0) {
			modelView = this.lendedBook(1);
		}
		return modelView;
	}
	
	//模糊查询可借图书 ajax test
//	@RequestMapping(value = "/findByBookName") //, method = RequestMethod.POST
////	@ResponseBody
//	public ModelAndView findByBookName(@RequestParam(required = true, defaultValue = "1") Integer page,HttpServletRequest request, HttpServletResponse response) throws Exception { //@RequestParam String book_Name,
//		String book_Name = request.getParameter("book_Name");
//
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//
//		ModelAndView modelView = new ModelAndView();
//		PageHelper.startPage(page, 10);
//		List<Book> blist = booService.findByBookName(book_Name);
//
////		String bjson = JSON.toJSONStringWithDateFormat(blist, "yyyy-MM-dd hh:mm");
//
////		PageInfo<Book> pageInfo = new PageInfo<>(blist);
//
//
//
//		String bjson = JSON.toJSONString(blist);
////		String pjson = JSON.toJSONString(pageInfo);
//
//		System.out.println(bjson);
////		System.out.println(pjson);
////
//		out.write(bjson);
////		out.flush();
////		out.close();
//
////		modelView.setViewName("showajax");
//		modelView.setViewName("hello");
//
////		return blist;
////		return bjson;
//		return modelView;
//	}
	
	//模糊查询可借图书
	@RequestMapping(value = "/findByBookName", method = RequestMethod.POST) //, method = RequestMethod.POST
	public ModelAndView findByBookName(@RequestParam(required = true, defaultValue = "1") Integer page, HttpServletRequest request) throws Exception { //@RequestParam String book_Name,
		String book_Name = request.getParameter("book_Name");
		ModelAndView modelView = new ModelAndView();
		PageHelper.startPage(page, 5);
		List<Book> blist = booService.findByBookName(book_Name);

		PageInfo<Book> pageInfo = new PageInfo<>(blist);


		modelView.addObject("pageInfo", pageInfo);
		modelView.addObject("blist", blist);
		modelView.addObject("bCount", pageInfo.getTotal()); // pageInfo.getTotal()获取总数
		modelView.setViewName("show");
		return modelView;
	}
	
	//模糊查询已借图书
	@RequestMapping(value = "/findByLendedBName", method = RequestMethod.POST) //, method = RequestMethod.POST
	public ModelAndView findByLendedBName(@RequestParam(required = true, defaultValue = "1") Integer page, HttpServletRequest request) throws Exception { //@RequestParam String book_Name,
		String book_Name = request.getParameter("book_Name");
		ModelAndView modelView = new ModelAndView();
		PageHelper.startPage(page, 5);
//		List<Book> blist = booService.findByBookName(book_Name);
		List<Book> blist = booService.findByLendedBName(book_Name);
		PageInfo<Book> pageInfo = new PageInfo<>(blist);
		
		
		modelView.addObject("pageInfo", pageInfo);
		modelView.addObject("blist", blist);
		modelView.addObject("bCount", pageInfo.getTotal()); // pageInfo.getTotal()获取总数
		
		modelView.setViewName("lendedb");
		return modelView;
	}
	
	//已借图书
	@RequestMapping(value = "lended")
	public ModelAndView lendedBook(@RequestParam(required = true, defaultValue = "1") Integer page) throws Exception{
		ModelAndView modelView = new ModelAndView();
		
		PageHelper.startPage(page, 10);
		
		//查询已借书籍信息
		List<Book> blist = booService.findLendedBooks();
		
		System.out.println(blist);
		
		PageInfo<Book> pageInfo = new PageInfo<>(blist);
		
		modelView.addObject("pageInfo", pageInfo);
		
		
		modelView.addObject("blist", blist);
		modelView.addObject("bCount", pageInfo.getTotal()); // pageInfo.getTotal()获取总数
		modelView.setViewName("lendedb");
		
		return modelView;
	}
	
	
}
