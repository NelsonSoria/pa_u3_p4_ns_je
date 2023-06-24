package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
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
	  Estudiante es =new Estudiante() ;
	  
	  es.setApellido("Espinosa");
	  es.setNombre("JOEL");
	  es.setCedula("216548");
	  //this.estudianteService.guardar(es);

	  
	  Estudiante es3 = this.estudianteService.buscarPorApellido("Soria");
	  System.out.println(es3);
	  List<Estudiante> estuList = this.estudianteService.reportePorApellido("Espinosa");
	  
	  for(Estudiante e :estuList) {
		  System.out.println(e);
	  }
	  Estudiante es2 = this.estudianteService.buscarPorApellidoYNombre("Espinosa","JOEL");
	  System.out.println(es2);
	  
	  Estudiante es1 = this.estudianteService.buscarPorApellidoTyped("Soria");
	  System.out.println(es1);
	  
	}

}
