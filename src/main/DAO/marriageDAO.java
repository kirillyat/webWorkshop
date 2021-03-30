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
    public marriageDAO findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Orders.class, id);
    }

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

    public List<Orders> loadAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> criteria = builder.createQuery(marriage.class);
        criteria.from(marriage.class);
        List<Orders> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }
// todo
    public List<Orders> selectUnreturnedOrders() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Orders> query = session.createQuery("FROM Orders WHERE order_returned is null");
        return query.getResultList();
    }

    public List<Orders> selectOrdersByStatus(boolean order_is_paid) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Orders> query = session.createQuery("FROM Orders WHERE order_is_paid = :param", Orders.class)
                .setParameter("param", order_is_paid);
        return query.getResultList();
    }
}