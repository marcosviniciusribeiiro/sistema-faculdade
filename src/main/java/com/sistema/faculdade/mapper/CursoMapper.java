package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.model.Curso;

public class CursoMapper {
	public static Curso toEntity(CursoDTO dto) {
		Curso c = new Curso();
		c.setId(dto.getId());
		c.setNome(dto.getNome());
		c.setAlunos(dto.getAlunos());
		return c;
	}
	
	public static CursoDTO toDTO(Curso c) {
		CursoDTO dto = new CursoDTO();
		dto.setId(c.getId());
		dto.setNome(c.getNome());
		dto.setAlunos(c.getAlunos());
		return dto;
	}
}
