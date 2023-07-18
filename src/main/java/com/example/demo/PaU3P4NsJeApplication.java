package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class PaU3P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService iMateriaService;
	
	@Autowired
	private IMatriculaService iMatriculaService;

	public static void main(String[] args) {
		SpringApplication.run(PaU3P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Provincia prov1 = new Provincia();
		prov1.setCodigo("QT");
		prov1.setNombre("Pichincha");
		prov1.setRegion("Sierra");
		
		Estudiante estu1 = new Estudiante();
		estu1.setApellido("Soria");
		estu1.setCedula("2515618165");
		estu1.setNombre("Nelson");
		estu1.setProvincia(prov1);
		
		Estudiante estu2 = new Estudiante();
		estu2.setApellido("Espinosa");
		estu2.setCedula("1233");
		estu2.setNombre("Joel");
		estu2.setProvincia(prov1);
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(estu1);
		estudiantes.add(estu2);
		prov1.setEstudiantes(estudiantes);
		
		Semestre s = new Semestre();
		s.setNumero("5");
		s.setPeriodo("2020-2021");
		s.setNombreCarrera("Computacion");
		
		Materia m1 = new Materia();
		m1.setCodigo("14g");
		m1.setNombre("Matematicas");
		m1.setNombreProfesor("Julio Profe");
		m1.setSemestre(s);
		
		Materia m2 = new Materia();
		m2.setCodigo("55l");
		m2.setNombre("Lengua");
		m2.setNombreProfesor("Davicho");
		m2.setSemestre(s);
		
		Materia m3 = new Materia();
		m3.setCodigo("001a");
		m3.setNombre("Fisica");
		m3.setNombreProfesor("Tamkech");
		m3.setSemestre(s);
		
		List<Materia> materias = new ArrayList<>();
		materias.add(m1);
		materias.add(m2);
		materias.add(m3);
		s.setMaterias(materias);
		//this.iMateriaService.guardar(m3);
		//this.iMateriaService.guardar(m2);
		//this.iMateriaService.guardar(m1);
		//this.estudianteService.guardar(estu2);
		//this.estudianteService.guardar(estu1);
		List<String> codigos = new ArrayList<>();
		codigos.add("001a");
		codigos.add("55l");
		this.iMatriculaService.matricular("1233", codigos);
	}

}
