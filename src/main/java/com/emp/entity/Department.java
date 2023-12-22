package com.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="ceated_at")
	private String ceatedAt;
	@Column(name="updated_at")
	private String updatedAt;
}
