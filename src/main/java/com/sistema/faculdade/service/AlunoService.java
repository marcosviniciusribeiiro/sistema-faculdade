package com.sistema.faculdade.service;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.repository.AlunoRepository;

@Service
public class AlunoService {
	public AlunoRepository alunoRepository;
	
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
}
