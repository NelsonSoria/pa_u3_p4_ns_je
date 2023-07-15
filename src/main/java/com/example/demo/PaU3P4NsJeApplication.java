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
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class PaU3P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private HabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(PaU3P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Hotel> myLista = this.hotelService.buscarInnerJoin();

		for (Hotel h : myLista) {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habiataciones");
			
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
			
		}
		System.out.println("SQL Join Fetch");
		List<Hotel> myListaF = this.hotelService.buscarFetchJoin();

		for (Hotel h : myListaF) {
			System.out.println(h.getNombre());
			System.out.println("FETCH Tiene las siguientes habiataciones");
			
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
			
		}
		
		Hotel h1=new Hotel();
		h1.setNombre("ECU2");
		h1.setDireccion("Cuenca3");
		
		Habitacion ha=new Habitacion();
		ha.setNumero("C02");
		ha.setValor(new BigDecimal(56));
		ha.setHotel(h1);
	    
		List<Habitacion> lista = new ArrayList<>();
		lista.add(ha);
		
		h1.setHabitaciones(lista);
		
		this.hotelService.guardar(h1);
		
		

		
	}

}
