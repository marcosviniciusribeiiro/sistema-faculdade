package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.model.Curso;

public class CursoMapper {
	public static Curso toEntity(CursoDTO dto) {
		Curso curso = new Curso();
		curso.setId(dto.getId());
		curso.setNome(dto.getNome());
		curso.setAlunos(dto.getAlunos());
		return curso;
	}
	
	public static CursoDTO toDTO(Curso curso) {
		CursoDTO dto = new CursoDTO();
		dto.setId(curso.getId());
		dto.setNome(curso.getNome());
		dto.setAlunos(curso.getAlunos());
		return dto;
	}
}
