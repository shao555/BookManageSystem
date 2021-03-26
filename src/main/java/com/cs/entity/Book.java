package com.cs.entity;

/**
 * @program: BookManageSystem
 * @description:
 * @author: xiaoyao
 * @create: 2021-03-14 18:01
 */
public class Book {
	
	private int book_ID;
	private String book_Name;
	private String book_Author;
	private String book_Publisher;
	private int lendable;
	
	public Book() {
	}
	
	public Book(int book_ID, String book_Name, String book_Author, String book_Publisher, int lendable) {
		this.book_ID = book_ID;
		this.book_Name = book_Name;
		this.book_Author = book_Author;
		this.book_Publisher = book_Publisher;
		this.lendable = lendable;
	}
	
	public int getBook_ID() {
		return book_ID;
	}
	
	public void setBook_ID(int book_ID) {
		this.book_ID = book_ID;
	}
	
	public String getBook_Name() {
		return book_Name;
	}
	
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	
	public String getBook_Author() {
		return book_Author;
	}
	
	public void setBook_Author(String book_Author) {
		this.book_Author = book_Author;
	}
	
	public String getBook_Publisher() {
		return book_Publisher;
	}
	
	public void setBook_Publisher(String book_Publisher) {
		this.book_Publisher = book_Publisher;
	}
	
	public int getLendable() {
		return lendable;
	}
	
	public void setLendable(int lendable) {
		this.lendable = lendable;
	}
	
	@Override
	public String toString() {
		return "Book{" +
				"book_ID=" + book_ID +
				", book_Name='" + book_Name + '\'' +
				", book_Author='" + book_Author + '\'' +
				", book_Publisher='" + book_Publisher + '\'' +
				", lendable=" + lendable +
				'}';
	}
}
