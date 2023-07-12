package com.example.demo;

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
			System.out.println(h.getHabitaciones());
		}

		List<Hotel> myLista2 = this.hotelService.buscarOuterRightJoin();

		for (Hotel h : myLista2) {
			System.out.println(h);
		}
		List<Hotel> myLista3 = this.hotelService.buscarOuterLeftJoin();

		for (Hotel h : myLista3) {
			System.out.println(h);
		}
		List<Habitacion> myLista4 = this.hotelService.buscarHabitacionOuterLeftJoin();

		for (Habitacion h : myLista4) {
			System.out.println(h);
		}

		List<Hotel> myLista5 = this.hotelService.buscarOuterFullJoin();

		for (Hotel h : myLista5) {
			if(h==null) {
				System.err.println("NO existe aun un hotel");
			}else {
				System.out.println(h.getNombre());
			}
			
		}
		List<Hotel> myLista6 = this.hotelService.buscarJoinWhere();

		for (Hotel h : myLista6) {
			System.out.println(h);
		}
	}

}
