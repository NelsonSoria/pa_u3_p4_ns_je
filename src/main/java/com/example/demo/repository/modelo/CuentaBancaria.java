package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class CuentaBancaria {
	
	@GeneratedValue(generator = "seq_cuenta_bancaria",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_cuenta_bancaria",sequenceName ="seq_cuenta_bancaria",allocationSize = 1 )
	@Id
	@Column(name="cuba_id")
	private Integer id;
	@Column(name="cuba_numero")
	private String numero;
	@Column(name="cuba_saldo")
	private BigDecimal saldo;
	@Column(name="cuba_tipo")
	private Character tipo;
	
	@ManyToOne
	@JoinColumn(name="cuba_prop_id")
	private Propietario propietario;
	
	
}
