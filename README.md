# Education CRM – Hibernate Project

## 📌 Project Overview
This is a console-based Java application developed using **Hibernate ORM** and **Maven**.
The project demonstrates core Hibernate concepts such as entity mapping, relationships,
CRUD operations, and database interaction.

The application is designed as an **Education CRM system** where customers can
purchase courses and receive payment confirmation.

---

## 🛠 Technologies Used
- Java
- Hibernate ORM
- Maven
- MySQL
- Git & GitHub

---

## 🧩 Entities
The project consists of the following main entities:

- **Customer**
- **Order**
- **Payment**

---

## 🔗 Relationships Implemented
- **Customer → Order** : Many-to-One  
  (One customer can place multiple orders)

- **Order → Payment** : One-to-One  
  (Each order has exactly one payment)

These relationships are implemented using Hibernate annotations
such as `@ManyToOne`, `@OneToOne`, and `@JoinColumn`.

---

## ✨ Features
- Customer CRUD operations
- Order creation linked to a customer
- Payment creation linked to an order
- Console-based course purchase flow
- Automatic bill generation in console
- Hibernate auto-generates SQL queries

---

## ▶ How to Run the Project
1. Clone the repository
2. Create a MySQL database (example: `education_crm`)
3. Update database credentials in `hibernate.cfg.xml`
4. Run `MainApp.java`
5. Use console menu options to test features

---

## 🧪 Sample Flow
1. Register a Customer  
2. Purchase a Course  
3. Order is created  
4. Payment is processed  
5. Bill is displayed in console  

---

## 📚 Notes
- This project focuses on **Hibernate ORM concepts**, not UI development.
- Advanced features like Spring Boot or frontend can be added later.
---

## 👨‍🎓 Author
Vikas Lokhande  
Student – Hibernate ORM Project
