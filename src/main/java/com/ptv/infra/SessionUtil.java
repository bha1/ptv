package com.ptv.infra;

import org.hibernate.Session;

public class SessionUtil {
	public static Session openSession(){
		return SessionFactoryUtil.getSessionFactory().openSession();
	}
			
	public static void closeSession(Session session){
		session.close();
	}
			
}