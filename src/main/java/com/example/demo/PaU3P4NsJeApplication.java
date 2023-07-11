package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;


@SpringBootApplication
public class PaU3P4NsJeApplication implements CommandLineRunner{

	@Autowired
	private HotelService hotelService;
	
    @Autowired
    private HabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaU3P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Hotel> myLista =this.hotelService.buscarInnerJoin();
		
		for(Hotel h: myLista) {
			System.out.println(h.getHabitaciones());
		}
	}

}
