package com.crm.service;

import com.crm.entity.Order;
import com.crm.entity.SupportTicket;

import javax.persistence.EntityManager;

public class TicketService {

    private EntityManager em;

    public TicketService(EntityManager em) {
        this.em = em;
    }

    public void raiseTicket(Long orderId, String issueDescription) {

        try {
            em.getTransaction().begin();

            Order order = em.find(Order.class, orderId);

            SupportTicket ticket = new SupportTicket();
            ticket.setIssueDescription(issueDescription);
            ticket.setOrder(order);

            em.persist(ticket);

            em.getTransaction().commit();
            System.out.println("Support Ticket Raised Successfully!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}