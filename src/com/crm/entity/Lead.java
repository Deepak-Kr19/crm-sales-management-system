package com.crm.entity;

import javax.persistence.*;

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "lead_seq")
    @SequenceGenerator(name = "lead_seq",
            sequenceName = "lead_sequence",
            allocationSize = 1)
    private Long id;

    private String name;
    private String source;
    private String contactInfo;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private SalesEmployee employee;

    public Lead() {}

    public Lead(String name, String source, String contactInfo) {
        this.name = name;
        this.source = source;
        this.contactInfo = contactInfo;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public SalesEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}

    // Getters & Setters
}