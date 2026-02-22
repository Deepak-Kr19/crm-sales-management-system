package com.crm.service;

import com.crm.entity.Lead;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public void getEmployeePerformance(Long employeeId) {

        TypedQuery<Lead> query = em.createQuery(
                "SELECT l FROM Lead l WHERE l.employee.id = :id",
                Lead.class);

        query.setParameter("id", employeeId);

        List<Lead> leads = query.getResultList();

        System.out.println("Total Leads Assigned: " + leads.size());
    }
}