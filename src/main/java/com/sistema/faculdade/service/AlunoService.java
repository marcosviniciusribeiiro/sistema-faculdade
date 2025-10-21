package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.AlunoDTO;
import com.sistema.faculdade.mapper.AlunoMapper;
import com.sistema.faculdade.model.Aluno;
import com.sistema.faculdade.model.Curso;
import com.sistema.faculdade.repository.AlunoRepository;

@Service
public class AlunoService {
	public AlunoRepository alunoRepository;
	public CursoService cursoService;
	
	public AlunoService(AlunoRepository alunoRepository, CursoService cursoService) {
		this.alunoRepository = alunoRepository;
		this.cursoService = cursoService;
	}
	
	public void salvarAluno(AlunoDTO dto) {
		Aluno aluno = AlunoMapper.toEntity(dto);
		
		Curso curso = cursoService.buscarEntidadePorId(dto.getCursoId());
		aluno.setCurso(curso);
		
		alunoRepository.save(aluno);
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