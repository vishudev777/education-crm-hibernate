package com.crm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crm.entity.Payment;
import com.crm.util.HibernateUtil;

public class PaymentDAO {

    public void savePayment(Payment payment) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.save(payment);
            tx.commit();

            System.out.println("Payment saved successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Payment getPaymentById(int id) {

        Payment payment = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            payment = session.get(Payment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return payment;
    }
}
