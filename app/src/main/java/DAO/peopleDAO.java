package DAO;

import models.people;
import models.marrige;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class peopleDAO {
    public people findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        people p = session.get(people.class, id);
        session.close();
        return p;
    }

    public void save(people p) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(p);
        tx1.commit();
        session.close();
    }

    public void update(people p) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(p);
        tx1.commit();
        session.close();
    }

    public void delete(people p) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(p);
        tx1.commit();
        session.close();
    }

    public List<people> loadAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<people> criteria = builder.createQuery(people.class);
        criteria.from(people.class);
        List<people> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }

}
