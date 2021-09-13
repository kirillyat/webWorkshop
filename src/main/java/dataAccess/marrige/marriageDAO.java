package DAO;

import entities.marriage;
import entities.people;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import java.util.List;


public class marriageDAO {

    public void save(marriage wedding) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(wedding);
        tx1.commit();
        session.close();
    }

    public void update(marriage wedding) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(wedding);
        tx1.commit();
        session.close();
    }

    public void delete(marriage wedding) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(wedding);
        tx1.commit();
        session.close();
    }

    public List<marriage> loadAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<marriage> criteria = builder.createQuery(marriage.class);
        criteria.from(marriage.class);
        List<marriage> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }

    public List<marriage> selectSucsessMarriage() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<marriage> query = session.createQuery("FROM marriage WHERE divorce_date is null");
        return query.getResultList();
    }

}