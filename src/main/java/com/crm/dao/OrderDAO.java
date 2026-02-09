package com.crm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crm.entity.Order;
import com.crm.util.HibernateUtil;

public class OrderDAO {

    public void saveOrder(Order order) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.save(order);
            tx.commit();

            System.out.println("Order saved successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Order getOrderById(int id) {

        Order order = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            order = session.get(Order.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }
}
