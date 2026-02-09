package com.crm.main;

import java.util.Scanner;

import com.crm.dao.CustomerDAO; //Customer 
import com.crm.entity.Customer;

import com.crm.dao.CourseDAO; //Course
import com.crm.entity.Course;

import com.crm.dao.TrainerDAO; //Trainer
import com.crm.entity.Trainer;

import com.crm.dao.PaymentDAO; //Payment
import com.crm.entity.Payment;

import com.crm.dao.OrderDAO; //Order
import com.crm.entity.Order;

public class MainApp
{

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);

		CustomerDAO dao = new CustomerDAO();
		CourseDAO courseDao = new CourseDAO();
		TrainerDAO trainerDao = new TrainerDAO();
		OrderDAO orderDao = new OrderDAO();
		PaymentDAO paymentDao = new PaymentDAO();

		System.out.println("==== Customer CRUD Menu ====");
		System.out.println("1. Insert Customer");
		System.out.println("2. View Customer");
		System.out.println("3. Update Customer City");
		System.out.println("4. Delete Customer");
		System.out.println(' ');
		System.out.println("5. Insert Course");
		System.out.println("6. View Course");
		System.out.println(' ');
		System.out.println("7. Insert Trainer");
		System.out.println("8. View Trainer");
		System.out.println(' ');
		System.out.println("9. Insert Order (with Customer)");
		System.out.println("10. Insert Payment (with Order)");
		System.out.println(' ');
		System.out.println("11. Purchase Course & Generate Bill");
		System.out.println(' ');
		System.out.println("0. Exit");

		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			Customer c = new Customer();

			System.out.print("Enter ID: ");
			c.setCustomerId(sc.nextInt());

			System.out.print("Enter Name: ");
			c.setName(sc.next());

			System.out.print("Enter Email: ");
			c.setEmail(sc.next());

			System.out.print("Enter Phone: ");
			c.setPhone(sc.next());

			System.out.print("Enter City: ");
			c.setCity(sc.next());

			dao.saveCustomer(c);
			break;

		case 2:
			System.out.print("Enter Customer ID: ");
			Customer customer = dao.getCustomerById(sc.nextInt());

			if (customer != null) {
				System.out.println("Name: " + customer.getName());
				System.out.println("Email: " + customer.getEmail());
				System.out.println("City: " + customer.getCity());
			} else {
				System.out.println("Customer not found");
			}
			break;

		case 3:
			System.out.print("Enter Customer ID: ");
			int id = sc.nextInt();

			System.out.print("Enter New City: ");
			String city = sc.next();

			dao.updateCustomerCity(id, city);
			break;

		case 4:
			System.out.print("Enter Customer ID: ");
			dao.deleteCustomer(sc.nextInt());
			break;

		case 0:
			System.out.println("Exiting...");
			break;

		case 5:
			Course course = new Course();

			System.out.print("Enter Course ID: ");
			course.setCourseId(sc.nextInt());
			sc.nextLine(); // // clear buffer

			System.out.print("Enter Course Name: ");
			course.setCourseName(sc.nextLine()); // allows spaces

			System.out.print("Enter Price: ");
			course.setPrice(sc.nextDouble());
			sc.nextLine(); // clear buffer

			System.out.print("Enter Duration: ");
			course.setDuration(sc.nextLine()); // allows spaces

			courseDao.saveCourse(course);
			break;

		case 6:
			System.out.print("Enter Course ID: ");
			Course c1 = courseDao.getCourseById(sc.nextInt());

			if (c1 != null) {
				System.out.println("Course Name: " + c1.getCourseName());
				System.out.println("Price: " + c1.getPrice());
				System.out.println("Duration: " + c1.getDuration());
			} else {
				System.out.println("Course not found");
			}
			break;

		case 7:
			Trainer t = new Trainer();

			System.out.print("Trainer ID: ");
			t.setTrainerId(sc.nextInt());
			sc.nextLine();

			System.out.print("Trainer Name: ");
			t.setTrainerName(sc.nextLine());

			System.out.print("Expertise: ");
			t.setExpertise(sc.nextLine());

			System.out.print("Phone: ");
			t.setPhone(sc.nextLine());

			trainerDao.saveTrainer(t);
			break;

		case 8:
			System.out.print("Trainer ID: ");
			Trainer tr = trainerDao.getTrainerById(sc.nextInt());

			if (tr != null) {
				System.out.println("Name: " + tr.getTrainerName());
				System.out.println("Expertise: " + tr.getExpertise());
				System.out.println("Phone: " + tr.getPhone());
			} else {
				System.out.println("Trainer not found");
			}
			break;

		case 9:
			Order order = new Order();

			System.out.print("Order ID: ");
			order.setOrderId(sc.nextInt());
			sc.nextLine();

			System.out.print("Order Date: ");
			order.setOrderDate(sc.nextLine());

			System.out.print("Amount: ");
			order.setAmount(sc.nextDouble());
			sc.nextLine();

			System.out.print("Customer ID: ");
			int custId = sc.nextInt();

			Customer cust = dao.getCustomerById(custId);
			if (cust == null) {
				System.out.println("Customer not found. Insert customer first.");
				break;
			}

			order.setCustomer(cust);
			orderDao.saveOrder(order);
			break;

		case 10:
			Payment payment = new Payment();

			System.out.print("Payment ID: ");
			payment.setPaymentId(sc.nextInt());
			sc.nextLine();

			System.out.print("Payment Status: ");
			payment.setPaymentStatus(sc.nextLine());

			System.out.print("Transaction ID: ");
			payment.setTransactionId(sc.nextLine());

			System.out.print("Order ID: ");
			int ordId = sc.nextInt();

			Order ord = orderDao.getOrderById(ordId);
			if (ord == null) {
				System.out.println("Order not found. Insert order first.");
				break;
			}

			payment.setOrder(ord);
			paymentDao.savePayment(payment);
			break;

		case 11:

		    // 1️⃣ Ask for Customer
		    System.out.print("Enter Customer ID: ");
		    int custIdForPurchase = sc.nextInt();

		    Customer purchaseCustomer = dao.getCustomerById(custIdForPurchase);
		    if (purchaseCustomer == null) {
		        System.out.println("Customer not found. Register first.");
		        break;
		    }

		    // 2️⃣ Show courses
		    System.out.println("\nAvailable Courses:");
		    System.out.println("1. Frontend Development - ₹2500");
		    System.out.println("2. Java Hibernate - ₹5000");

		    System.out.print("Select Course (1 or 2): ");
		    int courseChoice = sc.nextInt();

		    String courseName = "";
		    double price = 0;

		    if (courseChoice == 1) {
		        courseName = "Frontend Development";
		        price = 2500;
		    } else if (courseChoice == 2) {
		        courseName = "Java Hibernate";
		        price = 5000;
		    } else {
		        System.out.println("Invalid course selection");
		        break;
		    }

		    // 3️⃣ Create Order
		    Order purchaseOrder = new Order();
		    purchaseOrder.setOrderId((int) (Math.random() * 10000));
		    purchaseOrder.setOrderDate("2026-02-10");
		    purchaseOrder.setAmount(price);
		    purchaseOrder.setCustomer(purchaseCustomer);

		    orderDao.saveOrder(purchaseOrder);

		    // 4️⃣ Create Payment
		    Payment purchasePayment = new Payment();
		    purchasePayment.setPaymentId((int) (Math.random() * 10000));
		    purchasePayment.setPaymentStatus("SUCCESS");
		    purchasePayment.setTransactionId("TXN" + System.currentTimeMillis());
		    purchasePayment.setOrder(purchaseOrder);

		    paymentDao.savePayment(purchasePayment);

		    // 5️⃣ BILL
		    System.out.println("\n========= BILL =========");
		    System.out.println("Customer Name : " + purchaseCustomer.getName());
		    System.out.println("Course        : " + courseName);
		    System.out.println("Amount Paid   : ₹" + price);
		    System.out.println("Payment Status: SUCCESS");
		    System.out.println("Transaction ID: " + purchasePayment.getTransactionId());
		    System.out.println("========================");

		    break;


		default:
			System.out.println("Invalid choice");
		}

		sc.close();
	}
}
