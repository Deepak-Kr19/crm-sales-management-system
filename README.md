# 🚀 CRM Sales Management System

A Console-Based CRM (Customer Relationship Management) Application built using **Hibernate JPA** and **Oracle Database**.

This project demonstrates entity relationships, transaction handling, JPQL queries, and layered architecture using pure Hibernate (without Spring).

---

## 🏗 Project Type
- Console Application
- Pure Hibernate JPA (No Spring)
- Manual JAR Configuration
- Oracle Database Integration

---

## 📌 Features

### 👤 Customer Management
- Register Customer
- Add Address to Customer

### 📊 Lead Management
- Create Lead
- Assign Lead to Sales Employee
- Convert Lead to Customer

### 🛒 Product & Order Management
- Add Product
- Place Order (Multiple Products)
- Automatic Total Amount Calculation

### 🎫 Support System
- Raise Support Ticket for Orders

### 📈 Reporting
- View Employee Performance (Lead Count using JPQL)

---

## 🗂️ Project Structure

## 🗂️ Project Structure

```text
com.crm
│
├── entity
│   ├── Customer.java
│   ├── Address.java
│   ├── Lead.java
│   ├── SalesEmployee.java
│   ├── Product.java
│   ├── Order.java
│   └── SupportTicket.java
│
├── service
│   ├── CustomerService.java
│   ├── LeadService.java
│   ├── ProductService.java
│   ├── OrderService.java
│   ├── TicketService.java
│   └── ReportService.java
│
├── util
│   └── JPAUtil.java
│
└── main
    └── CRMApplication.java
```

---

## 🛠️ Technologies Used

- Java 8+
- Hibernate ORM 5.6.15.Final
- JPA (javax.persistence)
- Oracle Database
- JDBC
- Git

---

## 🗄️ Database

- Oracle XE
- Sequence-based ID generation
- Foreign Key Constraints
- Many-to-One, One-to-Many, Many-to-Many Mappings

---

## 🔁 Entity Relationships

- Customer → One-to-One → Address
- Customer → One-to-Many → Orders
- SalesEmployee → One-to-Many → Leads
- Order → Many-to-Many → Product
- Order → One-to-Many → SupportTicket

---

## ⚙️ How To Run

1. Configure Oracle Database
2. Update `persistence.xml` with your DB credentials
3. Set:

hibernate.hbm2ddl.auto = update

4. Run:

CRMApplication.java

---

## 📷 Console Menu
```text
===== CRM SALES MANAGEMENT SYSTEM =====
1. Register Customer
2. Add Address to Customer
3. Create Lead
4. Assign Lead to Employee
5. Convert Lead to Customer
6. Add Product
7. Place Order
8. Raise Support Ticket
9. View Employee Performance
10. Exit
```
---

## 🧠 Concepts Demonstrated

- JPA Entity Mapping
- Cascade Types
- Transaction Management
- JPQL Queries
- Sequence Generators
- Layered Architecture
- Console Menu Loop Design
- Manual Dependency Configuration

---

## 👨‍💻 Author

Deepak Kumar  
B.Tech CSE  
Full Stack Developer (Java Backend Focus)

---

## ⭐ Future Enhancements

- Add Update/Delete Operations
- Pagination
- Advanced Reporting Queries
- Convert to Spring Boot REST API
- Add Frontend UI

---

## 📌 Project Purpose

This project was built to demonstrate strong understanding of:
- Hibernate ORM
- Database Relationships
- Real-world CRM Design
- Clean Layered Architecture

---

⭐ If you found this helpful, feel free to star the repository!
