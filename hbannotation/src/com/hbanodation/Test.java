package com.hbanodation;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
public static void main(String[] args) {
	
	Scanner in=new Scanner(System.in);
	 Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	
	Transaction t=session.beginTransaction();
	
	System.out.println("Enter ID");
	int id=in.nextInt();
	System.out.println("Enter the Firstname");
	String fname=in.next();
	System.out.println("Enter the Lastname");
	String lname=in.next();
	
	Employee e1=new Employee();
	e1.setId(id);
	e1.setFirstName(fname);
	e1.setLastName(lname);
	
	session.persist(e1);
	
	t.commit();
	session.close();
	System.out.println("successfully saved");
}
}
