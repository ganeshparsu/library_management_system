package com.library;

public class Books1 {
	private String bookname;
//	private int id;
//	

	public Books1(String bookname) {
		super();
		this.bookname = bookname;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	@Override
	public String toString() {
		return  bookname ;
	}
}
