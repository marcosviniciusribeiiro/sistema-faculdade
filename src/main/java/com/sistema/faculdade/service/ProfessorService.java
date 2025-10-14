package com.sistema.faculdade.service;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.mapper.ProfessorMapper;
import com.sistema.faculdade.repository.ProfessorRepository;

@Service
public class ProfessorService {
	public ProfessorRepository professorRepository;
	
	public ProfessorService(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}
	
	public void salvarProfessor(ProfessorDTO dto) {
		professorRepository.save(ProfessorMapper.toEntity(dto));
	}
	
	public void deletarProfessor(Long id) {
		professorRepository.deleteById(id);
	}
}
