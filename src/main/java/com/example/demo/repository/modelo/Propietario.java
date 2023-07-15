package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Propietario {
	@GeneratedValue(generator = "seq_propietario",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_propietario",sequenceName ="seq_propietario",allocationSize = 1 )
	@Id
	@Column(name="prop_id")
	private Integer id;
	@Column(name="prop_cedula")
	private String nombre;
	@Column(name="prop_apellido")
	private String apellido;
	@Column(name="prop_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "propietario")
	private List<CuentaBancaria> cuentas;
	
}
