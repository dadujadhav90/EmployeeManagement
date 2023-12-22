package com.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class Employee {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private Department department;
	    @ManyToOne
	    @JoinColumn(name = "position_id")
	    private Designation designation;
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private String address;
	@Column(name="e_createdat")
	private String eCreatedAt;
	@Column(name="e_updatedAt")
	private String eUpdatedAt;
	
}
