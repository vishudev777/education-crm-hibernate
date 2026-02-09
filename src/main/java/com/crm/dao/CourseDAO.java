package com.crm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crm.entity.Course;
import com.crm.util.HibernateUtil;

public class CourseDAO {

    // CREATE
    public void saveCourse(Course course) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.save(course);

            tx.commit();

            System.out.println("Course saved successfully!");

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    // READ
    public Course getCourseById(int id) {

        Course course = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            course = session.get(Course.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }
}
