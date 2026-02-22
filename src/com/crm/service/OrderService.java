package com.crm.service;

import com.crm.entity.Customer;
import com.crm.entity.Order;
import com.crm.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;
import java.time.LocalDate;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Long customerId, List<Long> productIds) {

        try {
            em.getTransaction().begin();

            Customer customer = em.find(Customer.class, customerId);

            Order order = new Order();
            order.setCustomer(customer);
            order.setOrderDate(LocalDate.now().toString());

            double total = 0;

            for (Long pid : productIds) {
                Product product = em.find(Product.class, pid);
                order.getProducts().add(product);
                total += product.getPrice();
            }

            order.setTotalAmount(total);

            em.persist(order);

            em.getTransaction().commit();
            System.out.println("Order Placed Successfully! Total: " + total);

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}