package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.DisciplinaDTO;
import com.sistema.faculdade.mapper.DisciplinaMapper;
import com.sistema.faculdade.model.Disciplina;
import com.sistema.faculdade.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	public DisciplinaRepository disciplinaRepository;
	
	public DisciplinaService(DisciplinaRepository disciplinaRepository) {
		this.disciplinaRepository = disciplinaRepository;
	}
	
	public void salvarDisciplina(DisciplinaDTO dto) {
		disciplinaRepository.save(DisciplinaMapper.toEntity(dto));
	}
	
	public List<DisciplinaDTO> listarDisciplinas(){
		return disciplinaRepository.findAll().stream().map(DisciplinaMapper::toDTO).toList();
	}
	
	public DisciplinaDTO buscarPorId(Long id) {
		Disciplina d = disciplinaRepository.findById(id)
										   .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return DisciplinaMapper.toDTO(d);
	}
	
	public void excluirDisciplina(Long id) {
		disciplinaRepository.deleteById(id);
	}
}
