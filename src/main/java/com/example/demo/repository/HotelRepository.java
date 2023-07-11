package com.example.demo.repository;


import java.util.List;

import com.example.demo.repository.modelo.Hotel;

public interface HotelRepository {
	public void insertar(Hotel hotel);
	public void eliminar(Integer id);
	public Hotel seleccionarPorID(Integer id);
	public void actualizar(Hotel hotel);
	
	public Hotel seleccionarPorNumero(Integer n);
	public List<Hotel> seleccionarInnerJoin();

}
