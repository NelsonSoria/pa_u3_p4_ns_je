package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;
import com.example.demo.service.LibroService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutorService autorService;

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Libro miLibro1= new Libro();
		miLibro1.setTitulo("Inferencia Estadistica");
		miLibro1.setEditorial("Galindo");
	
		Libro miLibro2= new Libro();
		miLibro2.setTitulo(" Estadistica");
		miLibro2.setEditorial("Galindoooo");
		
		Autor miAutor1 = new Autor();
		miAutor1.setNombre("Daniela");
		miAutor1.setApellido("Parra");
		
		Autor miAutor2 = new Autor();
		miAutor2.setNombre("Juan");
		miAutor2.setApellido("pepito");
		
		Autor miAutor3 = new Autor();
		miAutor3.setNombre("Luis");
		miAutor3.setApellido("sandoval");
		
		Set<Libro> misLibros = new HashSet<>();
		misLibros.add(miLibro1);
		misLibros.add(miLibro2);
		
		Set<Autor> misAutores = new HashSet<>();
		misAutores.add(miAutor1);
		misAutores.add(miAutor2);
		misAutores.add(miAutor3);
		
		Set<Autor> misAutores2 = new HashSet<>();
		misAutores2.add(miAutor1);
		
		//misAutores2.add(miAutor2);
		miLibro1.setAutores(misAutores);
		miLibro2.setAutores(misAutores2);
		
		miAutor1.setLibros(misLibros);
		//this.libroService.guardar(miLibro1);
		//this.libroService.guardar(miLibro2);
		
		this.autorService.guardar(miAutor1);
		
	}

}
