package com.example.demo.respository;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface MatriculaRepository {
	
	public void insertar(Matricula matricula);

	public List<MatriculaDTO> seleccionarTodos();
}
