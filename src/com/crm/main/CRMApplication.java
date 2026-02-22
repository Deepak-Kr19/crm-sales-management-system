package com.crm.main;

import com.crm.entity.Address;
import com.crm.service.*;
import com.crm.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CRMApplication {

    public static void main(String[] args) {

        // Step 1: Create EntityManager
        EntityManager em = JPAUtil.getEntityManager();

        // Step 2: Create Service Objects
        CustomerService customerService = new CustomerService(em);
        LeadService leadService = new LeadService(em);
        ProductService productService = new ProductService(em);
        OrderService orderService = new OrderService(em);
        TicketService ticketService = new TicketService(em);
        ReportService reportService = new ReportService(em);

        // Step 3: Scanner
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== CRM SALES MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Support Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("10. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Phone: ");
                        String phone = sc.nextLine();

                        customerService.registerCustomer(name, email, phone);
                        break;

                    case 2:
                        System.out.print("Enter Customer ID: ");
                        Long custId = sc.nextLong();
                        sc.nextLine();

                        Address address = new Address();
                        System.out.print("Street: ");
                        address.setStreet(sc.nextLine());
                        System.out.print("City: ");
                        address.setCity(sc.nextLine());
                        System.out.print("State: ");
                        address.setState(sc.nextLine());
                        System.out.print("ZipCode: ");
                        address.setZipCode(sc.nextLine());

                        customerService.addAddressToCustomer(custId, address);
                        break;

                    case 3:
                        System.out.print("Lead Name: ");
                        String leadName = sc.nextLine();
                        System.out.print("Source: ");
                        String source = sc.nextLine();
                        System.out.print("Contact Info: ");
                        String contact = sc.nextLine();

                        leadService.createLead(leadName, source, contact);
                        break;

                    case 4:
                        System.out.print("Lead ID: ");
                        Long leadId = sc.nextLong();
                        System.out.print("Employee ID: ");
                        Long empId = sc.nextLong();
                        sc.nextLine();

                        leadService.assignLeadToEmployee(leadId, empId);
                        break;

                    case 5:
                        System.out.print("Lead ID to Convert: ");
                        Long convertId = sc.nextLong();
                        sc.nextLine();

                        leadService.convertLeadToCustomer(convertId);
                        break;

                    case 6:
                        System.out.print("Product Name: ");
                        String prodName = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        productService.addProduct(prodName, price);
                        break;

                    case 7:
                        System.out.print("Customer ID: ");
                        Long customerId = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Enter Product IDs (comma separated): ");
                        String input = sc.nextLine();
                        List<Long> productIds = Arrays.stream(input.split(","))
                                .map(String::trim)
                                .map(Long::parseLong)
                                .collect(java.util.stream.Collectors.toList());

                        orderService.placeOrder(customerId, productIds);
                        break;

                    case 8:
                        System.out.print("Order ID: ");
                        Long orderId = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Issue Description: ");
                        String issue = sc.nextLine();

                        ticketService.raiseTicket(orderId, issue);
                        break;

                    case 9:
                        System.out.print("Employee ID: ");
                        Long employeeId = sc.nextLong();
                        sc.nextLine();

                        reportService.getEmployeePerformance(employeeId);
                        break;

                    case 10:
                        System.out.println("Exiting Application...");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 10);

        // Step 7: Close Resources
        em.close();
        JPAUtil.closeFactory();
        sc.close();
    }
}