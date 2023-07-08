package com.example.demo.repository.modelo.dto;

import jakarta.persistence.Column;

public class EstudianteDTO {

	
	private String nombre;
	private String apellido;
	
	//Como buena practica se debe declara el constructor por defecto
	public EstudianteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EstudianteDTO(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	//SET T GET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "EstudianteDTO [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
