package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.EstudianteService;


@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//AND
		Estudiante estu7 = this.estudianteService.buscarEstudianteDinamico("Andrea", "Parra",101.0);
		System.err.println(estu7);	
		
		//OR
		Estudiante estu8 = this.estudianteService.buscarEstudianteDinamico("Andrea", "hola",99.0);
		System.err.println(estu8);	
		
		System.err.println(this.estudianteService.actualizarPorApellido("Javier", "Espinosa")); 
		System.err.println(this.estudianteService.borrarPorNombre("Andrea"));
				

	}

}