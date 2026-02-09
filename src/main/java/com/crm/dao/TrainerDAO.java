package com.crm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crm.entity.Trainer;
import com.crm.util.HibernateUtil;

public class TrainerDAO {

    public void saveTrainer(Trainer trainer) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();
            session.save(trainer);
            tx.commit();

            System.out.println("Trainer saved successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Trainer getTrainerById(int id) {

        Trainer trainer = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            trainer = session.get(Trainer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trainer;
    }
}
