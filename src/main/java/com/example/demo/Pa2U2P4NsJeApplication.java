package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.dto.EstudianteDTO;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private HotelService hotelService;
	
    @Autowired
    private HabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		
		//this.estudianteService.guardar(e1);

		List<EstudianteDTO> estudianteDTOs = this.estudianteService.reporteDTO();

		for (EstudianteDTO e : estudianteDTOs) {
			System.out.println(e);
		}
		
		List<MatriculaDTO> m5=this.matriculaService.reporteTodos();
			for (MatriculaDTO m1 : m5) {
				System.err.println(m1);
			}
			
		 Hotel h1=this.hotelService.buscarPorID(5);
		 System.out.println(h1.getNombre());
		
		 System.out.println(this.hotelService.cantidad(8).getHabitaciones());
		 
	}

}