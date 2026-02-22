package com.crm.service;

import com.crm.entity.Customer;
import com.crm.entity.Lead;
import com.crm.entity.SalesEmployee;

import javax.persistence.EntityManager;

public class LeadService {

    private EntityManager em;

    public LeadService(EntityManager em) {
        this.em = em;
    }

    // Create Lead
    public Lead createLead(String name, String source, String contactInfo) {

        try {
            em.getTransaction().begin();

            Lead lead = new Lead(name, source, contactInfo);
            em.persist(lead);

            em.getTransaction().commit();
            System.out.println("Lead Created Successfully!");

            return lead;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    // Assign Lead
    public void assignLeadToEmployee(Long leadId, Long employeeId) {

        try {
            em.getTransaction().begin();

            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee employee = em.find(SalesEmployee.class, employeeId);

            lead.setEmployee(employee);

            em.getTransaction().commit();
            System.out.println("Lead Assigned Successfully!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    // Convert Lead
    public void convertLeadToCustomer(Long leadId) {

        try {
            em.getTransaction().begin();

            Lead lead = em.find(Lead.class, leadId);

            Customer customer = new Customer(
                    lead.getName(),
                    lead.getContactInfo(),
                    "Converted"
            );

            em.persist(customer);

            em.remove(lead);

            em.getTransaction().commit();
            System.out.println("Lead Converted to Customer!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}