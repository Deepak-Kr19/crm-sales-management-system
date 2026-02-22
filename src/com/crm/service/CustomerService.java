package com.crm.service;

import com.crm.entity.Address;
import com.crm.entity.Customer;

import javax.persistence.EntityManager;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    // Register Customer
    public Customer registerCustomer(String name, String email, String phone) {

        try {
            em.getTransaction().begin();

            Customer customer = new Customer(name, email, phone);
            em.persist(customer);

            em.getTransaction().commit();
            System.out.println("Customer Registered Successfully!");

            return customer;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    // Add Address
    public void addAddressToCustomer(Long customerId, Address address) {

        try {
            em.getTransaction().begin();

            Customer customer = em.find(Customer.class, customerId);
            customer.setAddress(address);

            em.persist(address);

            em.getTransaction().commit();
            System.out.println("Address Added Successfully!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}