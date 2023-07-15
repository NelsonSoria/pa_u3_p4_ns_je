package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Transferencia {
	@GeneratedValue(generator = "seq_transferencia",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_transferencia",sequenceName ="seq_transferencia",allocationSize = 1 )
	@Id
	@Column(name="tran_id")
	private Integer id;
	
	@Column(name="tran_fecha")
	private LocalDateTime fecha;
	
	@Column(name="tran_monto")
	private BigDecimal monto;

}
