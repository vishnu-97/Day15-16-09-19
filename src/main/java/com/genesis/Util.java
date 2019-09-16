package com.genesis;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
	static SessionFactory getSF() {
		Configuration config=new Configuration().configure();
		return config.buildSessionFactory();
		
	}
}
