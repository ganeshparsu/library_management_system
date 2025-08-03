package com.library;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String id;
	private String name;
	private long phno;
	private String mailid;
	private String branch;
	private List<Books1> books;
	static int count=1001;
	public Student(String name, long phno, String mailid, String branch) {
		this.id="DSI"+count;
		this.name = name;
		this.phno = phno;
		this.mailid = mailid;
		this.branch = branch;
		this.books=new ArrayList<>();
		count++;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public List<Books1> getBooks() {
		return books;
	}
	public void setBooks(List<Books1> books) {
		this.books = books;
	}
	public String toString() {

		return " Library id : "+id+"\n Name : "+name+"\n Branch : "+branch+"\n Phone number : "+phno+"\n Mail id : "+mailid+ " \n books"+books;
	}
	
	
}
