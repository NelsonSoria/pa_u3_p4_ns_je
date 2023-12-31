package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService{
     
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public void guardar(Hotel hotel) {
		this.hotelRepository.insertar(hotel);;
		
	}

	@Override
	public void borrar(Integer id) {
		this.hotelRepository.eliminar(id);
		
	}

	@Override
	public Hotel buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);;
		
	}

	@Override
	public Hotel cantidad(Integer n) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorNumero(n);
	}

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin();
	}

}
