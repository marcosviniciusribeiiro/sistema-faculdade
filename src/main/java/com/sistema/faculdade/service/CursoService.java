package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.mapper.CursoMapper;
import com.sistema.faculdade.model.Curso;
import com.sistema.faculdade.repository.CursoRepository;

@Service
public class CursoService {
	public CursoRepository cursoRepository;
	
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public void salvarCurso(CursoDTO dto) {
		cursoRepository.save(CursoMapper.toEntity(dto));
	}
	
	public List<CursoDTO> listarCursos(){
		return cursoRepository.findAll().stream().map(CursoMapper::toDTO).toList();
	}
	
	public CursoDTO buscarPorId(Long id) {
		Curso c = cursoRepository.findById(id)
								 .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return CursoMapper.toDTO(c);
	}
	
	public void deletarCurso(Long id) {
		cursoRepository.deleteById(id);
	}
}
