package com.sistema.faculdade.mapper;

import java.util.List;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.model.Disciplina;
import com.sistema.faculdade.model.Professor;

public class ProfessorMapper {
	public static Professor toEntity(ProfessorDTO dto, List<Disciplina> disciplinas) {
		Professor p = new Professor();
		p.setId(dto.getId());
		p.setNome(dto.getNome());
		p.setDisciplinas(disciplinas);
		return p;
	}
	public static ProfessorDTO toDTO(Professor p) {
		ProfessorDTO dto = new ProfessorDTO();
		dto.setId(p.getId());
		dto.setNome(p.getNome());
		dto.setDisciplinasIds(p.getDisciplinas().stream().map(Disciplina::getId).toList());
		return dto;
	}
}
