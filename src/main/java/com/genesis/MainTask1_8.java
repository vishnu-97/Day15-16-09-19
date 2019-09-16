package com.genesis;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class MainTask1_8 {
	
	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static void main(String[] args) {
		SessionFactory sf=Util.getSF();
		Session session=sf.openSession();
		//******************************************Task1******************************************************
		System.out.println("@@@@@@@@@Data Insertion");
		
		Laptop l1=new Laptop(1,"dell",12332);
		Laptop l2=new Laptop(2,"hp",62332);
		
		Transaction t=session.beginTransaction();
		session.save(l1);
		session.save(l2);
		t.commit();
		t=session.beginTransaction();
		Employee e1=new Employee(1, "manav", 54454, new Address(51, "bhopal", "amrit"), new Laptop(1));
		Employee e2=new Employee(2, "shiv", 74454, new Address(57, "bhopal", "amrit"), new Laptop(2));
		session.save(e1);
		session.save(e2);
		t.commit();
		
		//******************************************Task2******************************************************
		System.out.println("@@@@@@@@@QBC");
		Criteria cr=session.createCriteria(Employee.class);
		List<Employee> l=cr.list();
		for(Employee e:l) {
			System.out.println(e);
		}
		
		//******************************************Task3******************************************************
		System.out.println("@@@@@@@@@Orders");
		Order o=Order.asc("esal");			
		cr.addOrder(o);
		l=cr.list();
		for(Employee e:l) {
			System.out.println(e);
		}
		
		
		//******************************************Task4******************************************************
		System.out.println("@@@@@@@@@Projection/Filters");
		Projection p1=Projections.property("ename");
		Projection p2=Projections.property("esal");
		ProjectionList plist=Projections.projectionList();
		plist.add(p1);
		plist.add(p2);
		cr.setProjection(plist);
		cr.add(Restrictions.like("ename", "%a%"));
		cr.add(Restrictions.lt("esal", 7000));
		List<Object[]> l11=cr.list();
		for(Object[] obj:l11) {
			for(Object val:obj)
				System.out.println(val);
		}
		
		
		//******************************************Task5******************************************************
		System.out.println("@@@@@@@@@HQL filteration/order");
		Query hql=session.createQuery("from Employee where esal>6000  order by ename");
		l=hql.getResultList();
		for(Employee e:l) {
			System.out.println(e);
		}
		
		
		//******************************************Task6******************************************************
		System.out.println("@@@@@@@@@HQL DML");
		hql=session.createQuery("update Laptop set price=78954 where code=1");
		t.begin();
		System.out.println(hql.executeUpdate()+" row(s) Updated from Laptop.");
		t.commit();
		hql=session.createQuery("from Laptop");
		List<Laptop> ll=hql.getResultList();
		for(Laptop e:ll) {
			System.out.println(e);
		}
		
		hql=session.createQuery("Delete from Employee where eno=1");
		t.begin();
		System.out.println(hql.executeUpdate()+" row(s) deleted from Employee.");
		t.commit();
		
		hql=session.createQuery("from Employee");
		l=hql.getResultList();
		for(Employee e:l) {
			System.out.println(e);
		}
		
		//******************************************Task7******************************************************
		System.out.println("@@@@@@@@@HQL Parameter");
		hql=session.createQuery("update Laptop set price=:p where code=:c");
		hql.setParameter("p", 45621f);
		hql.setParameter("c", 1);
		t.begin();
		System.out.println(hql.executeUpdate()+" row(s) Updated from Laptop.");
		t.commit();
		
		hql=session.createQuery("from Laptop");
		ll=hql.getResultList();
		for(Laptop e:ll) {
			System.out.println(e);
		}
		
		hql=session.createQuery("update Employee set ename=? where eno=?");
		hql.setParameter(0, "Vishnu");
		hql.setParameter(1, 2);
		t=session.beginTransaction();
		System.out.println(hql.executeUpdate()+" row(s) updated from Employee.");
		t.commit();
		
		hql=session.createQuery("from Employee");
		l=hql.getResultList();
		for(Employee e:l) {
			e.getLap();
			System.out.println(e);
		}
		
		//******************************************Task8******************************************************
		System.out.println("@@@@@@@@@HQL DML");
		
		SQLQuery sql=session.createSQLQuery("select * from Laptop");
		//
		sql.addEntity(Laptop.class);
		List<Laptop> sll=sql.list();
		for(Laptop e:ll) {
			System.out.println(e);
		}
	}

}
