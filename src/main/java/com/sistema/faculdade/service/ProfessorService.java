package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.mapper.ProfessorMapper;
import com.sistema.faculdade.model.Professor;
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
	
	public List<ProfessorDTO> listarProfessores(){
		return professorRepository.findAll().stream().map(ProfessorMapper::toDTO).toList();
	}
	
	public ProfessorDTO buscarPorId(Long id) {
		Professor p = professorRepository.findById(id)
										 .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return ProfessorMapper.toDTO(p);
	}
	
	public void deletarProfessor(Long id) {
		professorRepository.deleteById(id);
	}
}
