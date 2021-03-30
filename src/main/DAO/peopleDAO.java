package DAO;

import entities.people;
import entities.marriage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class peopleDAO {
    public people findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(people.class, id);
    }

    public void save(people human) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(human);
        tx1.commit();
        session.close();
    }

    public void update(people human) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(human);
        tx1.commit();
        session.close();
    }

    public void delete(people human) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(human);
        tx1.commit();
        session.close();
    }

    public List<people> loadAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Clients> criteria = builder.createQuery(people.class);
        criteria.from(people.class);
        List<people> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }
}