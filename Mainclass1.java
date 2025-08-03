package com.library;

import java.util.Scanner;

public class Mainclass1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Student1 student1=new Student1impl();
		
		
		while(true ) {
			
			System.out.println("=======================================");
			System.out.println("WelCome to Library Management System ");
			System.out.println("========================================");
			System.out.println(" 1 -> Add Student To Database \n 2 -> Book Issui \n 3 -> Book Return \n 4 -> Display Student Details   ");
			System.out.println(" 5 -> Display All Student Details \n 6 -> Remove Student From Database \n 7 -> Update Student Details \n 8 -> Exit ");
			int choice=s.nextInt();
			System.out.println("------------------------------------------");
			switch(choice) {
			case 1:
				student1.addstudent();
				break;
			case 2:
				student1.bookissuing();
				break;
			case 3:
				student1.bookreturning();
				break;
			case 4:
				student1.displaystudent();
				break;
			case 5:
			student1.displayallstudent();
			break;
			case 6: student1.removestudent();
			break;
			case 7:
				student1.updatestudent();
				break;
			case 8:
				System.out.println("Thank you !!");
				break;
				default : System.out.println("Invalid Option entered .Please Enter the Valid input ");
			}
		}

	}

}
