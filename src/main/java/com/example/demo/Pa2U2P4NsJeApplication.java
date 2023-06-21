package com.example.demo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Alumno;
import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.service.AutorService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LibroService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private MatriculaService matriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	  Alumno alum= new Alumno();
	  alum.setNombre("Nelson");
	  
	  Materia mat1= new Materia();
	  mat1.setNombre("PA2");
	  
	
	  Matricula matri= new Matricula();
	  matri.setFecha(LocalDateTime.now());
	  matri.setNumero("001");
	  matri.setAlumno(alum);
	  matri.setMateria(mat1);
	  
	  this.matriculaService.guardad(matri);
		
		
		
	}

}
