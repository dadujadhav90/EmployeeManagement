package com.emp.entity;

import java.math.BigDecimal;

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
@Table(name="salary")
public class Salary {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "position_id")
	    private Designation designation;
	    private BigDecimal basicSalary;
	    private BigDecimal hra;
	    private BigDecimal da;
	    private BigDecimal otherAllowances;
	    private BigDecimal grossSalary;
	    
	    @Column(name="crated_at")
		private String createdAt;
		@Column(name="updated_at")
		private String updatedAt;
}
