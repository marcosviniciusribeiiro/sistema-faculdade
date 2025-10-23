  package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.mapper.CursoMapper;
import com.sistema.faculdade.model.Curso;
import com.sistema.faculdade.model.Disciplina;
import com.sistema.faculdade.repository.CursoRepository;
import com.sistema.faculdade.repository.DisciplinaRepository;

@Service
public class CursoService {
	private final CursoRepository cursoRepository;
	private final DisciplinaRepository disciplinaRepository;
	
	public CursoService(CursoRepository cursoRepository, DisciplinaRepository disciplinaRepository) {
		this.cursoRepository = cursoRepository;
		this.disciplinaRepository = disciplinaRepository;
	}
	
	public void salvarCurso(CursoDTO dto) {
		List<Disciplina> disciplinas = disciplinaRepository.findAllById(dto.getDisciplinasIds());
		Curso curso = CursoMapper.toEntity(dto, disciplinas);
		
		cursoRepository.save(curso);
	}
	
	public List<CursoDTO> listarCursos(){
		return cursoRepository.findAll().stream().map(CursoMapper::toDTO).toList();
	}
	
	public CursoDTO buscarPorId(Long id) {
		Curso curso = cursoRepository.findById(id)
								 .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return CursoMapper.toDTO(curso);
	}
	
	public Curso buscarEntidadePorId(Long id) {
	    return cursoRepository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado: " + id));
	}
	
	public void excluirCurso(Long id) {
		cursoRepository.deleteById(id);
	}
}
