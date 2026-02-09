package com.crm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crm.entity.Customer;
import com.crm.util.HibernateUtil;

public class CustomerDAO
{

	public void saveCustomer(Customer customer)
	{

		Transaction tx = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			session.save(customer);

			tx.commit();

			System.out.println("Customer saved successfully!");

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

//    ------------------------------------------------------------------------------------------------
//    CRUD's (READ)
	public Customer getCustomerById(int id)
	{

		Customer customer = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			customer = session.get(Customer.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;
	}

//  ------------------------------------------------------------------------------------------------
//  CRUD's (UPDATE)
	public void updateCustomerCity(int id, String newCity)
	{

		Transaction tx = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			Customer customer = session.get(Customer.class, id);

			if (customer != null) {
				customer.setCity(newCity);
				session.update(customer);
				System.out.println("Customer updated successfully!");
			} else {
				System.out.println("Customer not found!");
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

//  ------------------------------------------------------------------------------------------------
//  CRUD's (DELETE)
	public void deleteCustomer(int id)
	{

		Transaction tx = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();

			Customer customer = session.get(Customer.class, id);

			if (customer != null) {
				session.delete(customer);
				System.out.println("Customer deleted successfully!");
			} else {
				System.out.println("Customer not found!");
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

}
