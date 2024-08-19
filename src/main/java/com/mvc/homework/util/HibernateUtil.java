package com.mvc.homework.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
        	// 建立Configuration -> 讀取hibernate.cfg.xml -> 建立SessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("初始化 HibernateUtil 失敗", e);
        } catch (Throwable ex) {
			System.err.println("SessionFactory 建立失敗:" + ex.getMessage());
	        throw new ExceptionInInitializerError(ex);
	    }
    }

    // SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // SessionFactory
    public static void shutdown() {
        getSessionFactory().close();
    }

}
