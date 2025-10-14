package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.DisciplinaDTO;
import com.sistema.faculdade.model.Disciplina;

public class DisciplinaMapper {
	public static Disciplina toEntity(DisciplinaDTO dto) {
		Disciplina d = new Disciplina();
		d.setId(dto.getId());
		d.setNome(dto.getNome());
		d.setProfessores(dto.getProfessores());
		return d;
	}
	public static DisciplinaDTO toDTO(Disciplina d) {
		DisciplinaDTO dto = new DisciplinaDTO();
		dto.setId(d.getId());
		dto.setNome(d.getNome());
		dto.setProfessores(d.getProfessores());
		return dto;
	}
}
