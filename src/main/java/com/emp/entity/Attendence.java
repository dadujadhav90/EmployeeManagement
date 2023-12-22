package com.emp.entity;

import java.time.LocalDateTime;

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
public class Attendence {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "employee_id")
	    private Employee employee;
	    private LocalDateTime inTime;
	    private LocalDateTime outTime;
	    
	    @Column(name="crated_at")
		private String createdAt;
		@Column(name="updated_at")
		private String updatedAt;
}
