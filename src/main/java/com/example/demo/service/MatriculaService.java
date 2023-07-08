package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface MatriculaService {
	public void guardad(Matricula matricula);
	public List<MatriculaDTO> reporteTodos();
}
