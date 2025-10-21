package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.DisciplinaDTO;
import com.sistema.faculdade.model.Disciplina;

public class DisciplinaMapper {
	public static Disciplina toEntity(DisciplinaDTO dto) {
		Disciplina disciplina = new Disciplina();
		disciplina.setId(dto.getId());
		disciplina.setNome(dto.getNome());
		disciplina.setProfessores(dto.getProfessores());
		return disciplina;
	}
	public static DisciplinaDTO toDTO(Disciplina disciplina) {
		DisciplinaDTO dto = new DisciplinaDTO();
		dto.setId(disciplina.getId());
		dto.setNome(disciplina.getNome());
		dto.setProfessores(disciplina.getProfessores());
		return dto;
	}
}
