package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.mapper.ProfessorMapper;
import com.sistema.faculdade.model.Disciplina;
import com.sistema.faculdade.model.Professor;
import com.sistema.faculdade.repository.DisciplinaRepository;
import com.sistema.faculdade.repository.ProfessorRepository;

@Service
public class ProfessorService {
	private final ProfessorRepository professorRepository;
	private final DisciplinaRepository disciplinaRepository;
	
	
	public ProfessorService(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository) {
		this.professorRepository = professorRepository;
		this.disciplinaRepository = disciplinaRepository;
	}
	
	public void salvarProfessor(ProfessorDTO dto) {
		List<Disciplina> disciplinas = disciplinaRepository.findAllById(dto.getDisciplinasIds());
		Professor professor = ProfessorMapper.toEntity(dto, disciplinas);
		
		professorRepository.save(professor);
	}
	
	public List<ProfessorDTO> listarProfessores(){
		return professorRepository.findAll().stream().map(ProfessorMapper::toDTO).toList();
	}
	
	public ProfessorDTO buscarPorId(Long id) {
		Professor p = professorRepository.findById(id)
										 .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return ProfessorMapper.toDTO(p);
	}
	
	public void excluirProfessor(Long id) {
		professorRepository.deleteById(id);
	}
}