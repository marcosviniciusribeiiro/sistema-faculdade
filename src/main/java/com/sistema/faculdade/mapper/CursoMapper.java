package com.sistema.faculdade.mapper;

import java.util.List;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.model.Aluno;
import com.sistema.faculdade.model.Curso;
import com.sistema.faculdade.model.Disciplina;

public class CursoMapper {
	public static Curso toEntity(CursoDTO dto, List<Disciplina> disciplinas, List<Aluno> alunos) {
		Curso curso = new Curso();
		curso.setId(dto.getId());
		curso.setNome(dto.getNome());
		curso.setAlunos(alunos);
		curso.setDisciplinas_curso(disciplinas);
		return curso;
	}
	
	public static CursoDTO toDTO(Curso curso) {
		CursoDTO dto = new CursoDTO();
		dto.setId(curso.getId());
		dto.setNome(curso.getNome());
		dto.setAlunosIds(curso.getAlunos().stream().map(Aluno::getId).toList());
		dto.setDisciplinasIds(curso.getDisciplinas_curso().stream().map(Disciplina::getId).toList());
		return dto;
	}
}
