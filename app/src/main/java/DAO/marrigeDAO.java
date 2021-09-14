package DAO;

import models.people;
import models.marrige;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class marrigeDAO {
    public marrige findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        marrige m = session.get(marrige.class, id);
        session.close();
        return m;
    }

    public marrige findByWifeId(int wife_id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        marrige m = session.get(marrige.class, wife_id);
        session.close();
        return m;
    }

    public void save(marrige m) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(m);
        tx1.commit();
        session.close();
    }

    public void update(marrige m) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(m);
        tx1.commit();
        session.close();
    }

    public void delete(marrige m) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(m);
        tx1.commit();
        session.close();
    }

    public List<marrige> loadAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<marrige> criteria = builder.createQuery(marrige.class);
        criteria.from(marrige.class);
        List<marrige> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }

}
