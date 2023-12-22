package com.emp.entity;

import jakarta.persistence.CascadeType;
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
@Table(name="designation")
public class Designation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="crated_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "department_id", referencedColumnName = "department_id")
	 private Department department;
}
