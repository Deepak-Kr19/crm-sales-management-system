package com.crm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SalesEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq",
            sequenceName = "employee_sequence",
            allocationSize = 1)
    private Long id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "employee")
    private List<Lead> leads = new ArrayList<>();

    public SalesEmployee() {}

    public SalesEmployee(String name, String department) {
        this.name = name;
        this.department = department;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

    // Getters & Setters
}