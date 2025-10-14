package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.AlunoDTO;
import com.sistema.faculdade.mapper.AlunoMapper;
import com.sistema.faculdade.model.Aluno;
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
	
	public AlunoDTO buscarPorId(Long id) {
		Aluno a = alunoRepository.findById(id)
								 .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return AlunoMapper.toDTO(a);
	}
	
	public void excluirAluno(Long id) {
		alunoRepository.deleteById(id);
	}
}