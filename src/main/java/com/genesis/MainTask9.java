package com.genesis;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainTask9 {

	public static void main(String[] args) {
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		//******************************************Task8******************************************************
		System.out.println("@@@@@@@@@Data Insertion");
		
		Vehicle v1=new Vehicle(1,"Lamborgini","54fcfg67g",1245332f);
		Vehicle v2=new Vehicle(2,"Spartan","fc0fg67g",845332f);
		Vehicle v3=new Vehicle(3,"Scoda","fg67g",445332f);
		//create
		Transaction t=session.beginTransaction();
		session.save(v1);
		session.save(v2);
		session.save(v3);
		t.commit();
		
		Laptop l1=new Laptop(1,"dell",12332);
		Laptop l2=new Laptop(2,"hp",62332);
		
		t=session.beginTransaction();
		session.save(l1);
		session.save(l2);
		t.commit();

		t=session.beginTransaction();
		Employee e1=new Employee(1, "manav", 54454, new Address(51, "bhopal", "amrit"), new Laptop(1),new Vehicle(1));
		Employee e2=new Employee(2, "shiv", 74454, new Address(57, "bhopal", "amrit"), new Laptop(2),new Vehicle(2));
		session.save(e1);
		session.save(e2);
		t.commit();
		
		//Read
		System.out.println("@@@@@@@@@Data Read");
		
		Criteria cr=session.createCriteria(Employee.class);
		List<Employee> l=cr.list();
		for(Employee e:l) {
			System.out.println(e);
		}
		cr=session.createCriteria(Laptop.class);
		List<Laptop> l11=cr.list();
		for(Laptop e:l11) {
			System.out.println(e);
		}
		cr=session.createCriteria(Vehicle.class);
		List<Vehicle> l111=cr.list();
		for(Vehicle e:l111) {
			System.out.println(e);
		}
		
		//Update
		System.out.println("@@@@@@@@@Data Update");
		
		Vehicle v4=session.get(Vehicle.class,1);
		v4.setBrand("Farari");
		t.begin();
		session.update(v4);
		t.commit();
		
		//Delete
		System.out.println("@@@@@@@@@Data Delete");
		
		v4=session.get(Vehicle.class,3);
		t.begin();
		session.delete(v4);
		t.commit();
		
		cr=session.createCriteria(Vehicle.class);
		l111=cr.list();
		for(Vehicle e:l111) {
			System.out.println(e);
		}
		
	}

}
