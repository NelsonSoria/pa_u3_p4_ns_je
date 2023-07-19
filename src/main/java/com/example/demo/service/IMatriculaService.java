package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	public void matricular(String cedulaEstudiante,List<String> codigosMateria);
	public List<Matricula> reporteTodos();
}
