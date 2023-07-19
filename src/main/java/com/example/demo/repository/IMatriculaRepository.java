package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaRepository {

	public void insertar(Matricula matricula);
	public void eliminar(Integer id);
	public Matricula seleccionarPorID(Integer id);
	public void actualizar(Matricula matricula);
	public List<Matricula> seleccionarTodos();
	
}
