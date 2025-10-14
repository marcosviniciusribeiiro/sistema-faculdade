package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.AlunoDTO;
import com.sistema.faculdade.mapper.AlunoMapper;
import com.sistema.faculdade.repository.AlunoRepository;

@Service
public class AlunoService {
	public AlunoRepository alunoRepository;
	
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public void salvarAluno(AlunoDTO dto) {
		alunoRepository.save(AlunoMapper.toEntity(dto));
	}
	
	public List<AlunoDTO> listarAlunos(){
		return alunoRepository.findAll().stream().map(AlunoMapper::toDTO).toList();
	}
}
