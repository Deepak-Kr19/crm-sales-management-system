package com.crm.service;

import com.crm.entity.Product;

import javax.persistence.EntityManager;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public Product addProduct(String name, double price) {

        try {
            em.getTransaction().begin();

            Product product = new Product(name, price);
            em.persist(product);

            em.getTransaction().commit();
            System.out.println("Product Added Successfully!");

            return product;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}