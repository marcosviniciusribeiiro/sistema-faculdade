package com.sistema.faculdade.mapper;

import java.util.List;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.model.Disciplina;
import com.sistema.faculdade.model.Professor;

public class ProfessorMapper {
	public static Professor toEntity(ProfessorDTO dto, List<Disciplina> disciplinas) {
		Professor professor = new Professor();
		professor.setId(dto.getId());
		professor.setNome(dto.getNome());
		professor.setDisciplinas(disciplinas);
		return professor;
	}
	public static ProfessorDTO toDTO(Professor professor) {
		ProfessorDTO dto = new ProfessorDTO();
		dto.setId(professor.getId());
		dto.setNome(professor.getNome());
		dto.setDisciplinasIds(professor.getDisciplinas().stream().map(Disciplina::getId).toList());
		return dto;
	}
}
