package com.sistema.faculdade.mapper;

import java.util.List;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.model.Curso;
import com.sistema.faculdade.model.Disciplina;

public class CursoMapper {
	public static Curso toEntity(CursoDTO dto, List<Disciplina> disciplinas) {
		Curso curso = new Curso();
		curso.setId(dto.getId());
		curso.setNome(dto.getNome());
		curso.setAlunos(dto.getAlunos());
		curso.setDisciplinas_curso(disciplinas);
		return curso;
	}
	
	public static CursoDTO toDTO(Curso curso) {
		CursoDTO dto = new CursoDTO();
		dto.setId(curso.getId());
		dto.setNome(curso.getNome());
		dto.setAlunos(curso.getAlunos());
		dto.setDisciplinasIds(curso.getDisciplinas_curso().stream().map(Disciplina::getId).toList());
		return dto;
	}
}
