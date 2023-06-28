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
		
		Estudiante estu= new Estudiante();
		estu.setNombre("Andrea");
		estu.setApellido("Parra");
		estu.setCedula("165468456");
		//this.estudianteService.guardar(estu);
		
		Estudiante estu1= this.estudianteService.buscaPorApellidoNamed("Soria");
		System.err.println(estu1);
		
		Estudiante estu2= this.estudianteService.buscaPorApellidoNamedQuery("Parra");
		System.err.println(estu2);
		
		Estudiante estu3= this.estudianteService.buscarPorApellidoNativeQuery("Soria");
		System.err.println(estu3);
		
		Estudiante estu4= this.estudianteService.buscarPorApellidoNativeQueryNamed("Parra");
		System.err.println(estu4);
		
		Estudiante estu5= this.estudianteService.buscarPorNombreNamedQuery("Nelson");
		System.err.println(estu5);
		
		Estudiante estu6= this.estudianteService.buscarPorNombreNativeQueryNamed("JOEL");
		System.err.println(estu6);

	}

}