package com.crm.entity;

import javax.persistence.*;

@Entity
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq",
            sequenceName = "ticket_sequence",
            allocationSize = 1)
    private Long id;

    private String issueDescription;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public SupportTicket() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

    // Getters & Setters
}