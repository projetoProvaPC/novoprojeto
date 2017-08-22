package br.edu.ifpe.garanhuns.provapc.model.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Eduardo
 */
public class DaoManagerHiber{

    private static DaoManagerHiber myself = null;
    private SessionFactory sessionFactory;
    private Session s;

    private DaoManagerHiber() {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            s = sessionFactory.openSession();
        } catch (Throwable th) {
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static DaoManagerHiber getInstance() {
        if (myself == null) myself = new DaoManagerHiber();

        return myself;
    }

    public void persist(Object o) {
        Transaction tr = null;
        try {
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
            s.save(o);
            tr.commit();
        } catch (RuntimeException e) {
            if (tr != null) tr.rollback();
            throw e;
        } finally {
            s.close();
        }
    }

    public List recover(String hql) {
        Transaction tr = null;
        List l = null;
        try {
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
            Query query = s.createQuery(hql);
            tr.commit();
            s.flush();
            l = query.list();
            return l;
        } catch (RuntimeException e) {
            if (tr != null) tr.rollback();
            throw e;
        } finally {
            s.close();
        }
    }

    
    public List recover(String hql, long id) {
        Transaction tr = null;
        List l = null;
        try {
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
            Query q = s.createQuery(hql);
            q.setLong("id", id);
            tr.commit();
            s.flush();
            l = q.list();
            return l;
        } catch (RuntimeException e) {
            if (tr != null) tr.rollback();
            throw e;
        } finally {
            s.close();
        }
    }

    public List recoverSQL(String sql) {
        Transaction tr = null;
        List l = null;
        try {
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
            Query query = s.createSQLQuery(sql);
            tr.commit();
            s.flush();
            l = query.list();
            return l;
        } catch (RuntimeException e) {
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        } finally {
            s.close();
        }
    }

    public void update(Object o) {
        Transaction tr = null;
        try {
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
            s.merge(o);
            tr.commit();
            s.flush();
        } catch (RuntimeException e) {
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        } finally {
            s.close();
        }
    }

    public void delete(Object o) {
        Transaction tr = null;
        try {
            s = sessionFactory.openSession();
            tr = s.beginTransaction();
            s.delete(o);
            tr.commit();
            s.flush();
        } catch (RuntimeException e) {
            if (tr != null) tr.rollback();
            throw e;
        } finally {
            s.close();
        }
    }

    public static void main(String args[]) {
        SchemaExport se = new SchemaExport(new AnnotationConfiguration().configure());
        se.create(true, true);
    }

}
