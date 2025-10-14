package com.sistema.faculdade.repository;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.mapper.CursoMapper;

@Service
public class CursoService {
	public CursoRepository cursoRepository;
	
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public void salvarCurso(CursoDTO dto) {
		cursoRepository.save(CursoMapper.toEntity(dto));
	}
}
