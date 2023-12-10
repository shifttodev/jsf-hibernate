package io.shifttodev.jsfhibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ConnectionFactoryHBN {

    private static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();

    static {
        try{
            sessionFactory = new AnnotationConfiguration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable t){
            throw new RuntimeException(t);
        }
    }

    public static Session getInstance(){
        Session session = (Session) threadLocal.get();
        session = sessionFactory.openSession();
        threadLocal.set(session);
        return session;
    }
}
