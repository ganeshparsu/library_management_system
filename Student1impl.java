package com.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Student1impl implements Student1 {
	Scanner sc=new Scanner(System.in);

	Map<String,Student> db=new LinkedHashMap<String, Student>();
	Set<String> keys;

	//	List<Student> list=new ArrayList<Student>();

	List<Books1> book;
	public void addstudent() {
		System.out.println("Enter The Student Name : ");
		String name=sc.next();
		System.out.println("Enter Student's Branch :");
		String branch=sc.next();
		System.out.println("Enter Student's Phone Number : ");
		long phno=sc.nextLong();
		System.out.println("Enter student's Mail Id :");
		String mail=sc.next();
		Student std=new Student(name, phno, mail, branch);
		db.put(std.getId(), std);
		//		Books1 book=new Books1();



		System.out.println("Student record inserted successfully ");
		System.out.println("Your library Id is : "+std.getId());
		keys=db.keySet();

	}
	public void bookissuing() {
		System.out.println("Enter the student Library Id ");
		String stdid=sc.next().toUpperCase();
		if(db.containsKey(stdid)) {
			Student std=db.get(stdid);
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the Book Name to be Issuied");
			String bookname=s.nextLine().toUpperCase();
			Books1 bookissui=new Books1(bookname);

			Student S=db.get(stdid);

			if(!S.getBooks().isEmpty()) {
				book=S.getBooks();
			}else {
				book=new ArrayList<Books1>();	
			}
			book.add(bookissui);
			S.setBooks(book);;
			System.out.println("Library Id :"+std.getId()+" \n Name : "+std.getName()+" \n Books Taken : "+S.getBooks());
		}else {
			try {
				String message="Student with "+stdid+" is not found ";
				throw new StudentNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	public void bookreturning() {
		book=new ArrayList<Books1>();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Student Library Id ");
		String stdid=s.nextLine().toUpperCase();
		if(db.containsKey(stdid)) {
			Student std=db.get(stdid);
			System.out.println("Enter the Book name which is returing by the Student ");
			String bookname=sc.next().toUpperCase();
			//		Books1 bookreturn=new Books1(bookname);
			book=std.getBooks();
			//		book.remove(bookname);
			Iterator<Books1> iterator = book.iterator();
			while (iterator.hasNext()) {
				Books1 b = iterator.next();
				if (b.getBookname().equals(bookname)) {
					iterator.remove();
					break; // Exit loop once the book is found and removed
				}
			}
			std.setBooks(book);
			System.out.println(" Library Id : "+std.getId()+" \n Name : "+std.getName()+" \n Returning Book Name : "+bookname+ " \n Due Books : "+std.getBooks());
		}
		else {
			try {
				String message=" Student with "+stdid+" is not found ";
				throw new StudentNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	public void displaystudent() {
		System.out.println("Enter the Student Library Id :");
		String stdid=sc.next().toUpperCase();
		if(db.containsKey(stdid)) {
			Student std=db.get(stdid);
			System.out.println("Displaying Student Details");
			System.out.println("---------------------------");
			System.out.println("Id : "+std.getId());
			System.out.println("Name : "+std.getName());;
			System.out.println("Branch : "+std.getBranch());;
			System.out.println("Phone number : "+std.getPhno());
			System.out.println("Mail Id : "+std.getMailid());
			System.out.println("Books  : "+std.getBooks());
		}
		else {
			try {
				String message="Student with "+stdid+" is not found ";
				throw new StudentNotFoundException(message);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	public void displayallstudent() {
		if(db.size()>0) {
			System.out.println("Student Record are as follows ");
			System.out.println("-------------------------------");
			for(String key:keys) {
				System.out.println(db.get(key));
				System.out.println("--------------------------");
			}
		}
		else {
			try {
				String message ="No sufficient student record to display";
				throw new StudentNotFoundException(message) ;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}	
		}
	}

	public void removestudent() {
		System.out.println("Enter the Library Id : ");
		String stdid=sc.next().toUpperCase();;

		if(db.containsKey(stdid)) {
			System.out.println(db.remove(stdid));
			System.out.println("Student record removed successfully ");
		}
		else {
			try {
				String message="No student found with "+stdid;
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void updatestudent() {
		System.out.println("Enter the Id :");
		String stdid=sc.next().toUpperCase();
		if(db.containsKey(stdid)) {
			Student std=db.get(stdid);
			System.out.println("Choose your options to update ");
			System.out.println("------------------------------");
			System.out.println("1 -> Update Name \n 2 -> Branch \n 3 -> Phone Number \n 4 -> Mail Id \n 5 -> Exit \n");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter the name to update : ");
			String name=sc.next();
			std.setName(name);
			System.out.println("Name updated successfully ");
			break;
			case 2: System.out.println("Enter branch name to update :");
			String branch=sc.next();
			std.setBranch(branch);
			System.out.println("Student branch updated successfully  ");
			break;
			case 3 :System.out.println("Enter Student Phone number to update ");
			long phno=sc.nextLong();
			std.setPhno(phno);
			System.out.println("Phone number updated successfully ");
			break;
			case 4 :System.out.println("Enter student Mail Id ");
			String mailid=sc.next();
			std.setMailid(mailid);
			System.out.println("updated MailId successfully ");
			break;
			case 5 :
				System.out.println("thank you !!");
				break ;
			default : System.out.println("Invalid option  . please enter the valid input ");

			}
		}
	}


}
