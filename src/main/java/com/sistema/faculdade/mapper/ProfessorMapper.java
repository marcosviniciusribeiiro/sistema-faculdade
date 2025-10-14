package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.ProfessorDTO;
import com.sistema.faculdade.model.Professor;

public class ProfessorMapper {
	public static Professor toEntity(ProfessorDTO dto) {
		Professor p = new Professor();
		p.setMatricula(dto.getMatricula());
		p.setNome(dto.getNome());
		p.setDisciplinas(dto.getDisciplinas());
		return p;
	}
	public static ProfessorDTO toDTO(Professor p) {
		ProfessorDTO dto = new ProfessorDTO();
		dto.setMatricula(p.getMatricula());
		dto.setNome(p.getNome());
		dto.setDisciplinas(p.getDisciplinas());
		return dto;
	}
}
