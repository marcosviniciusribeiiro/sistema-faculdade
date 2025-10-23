package com.sistema.faculdade.dto;

import java.util.List;

import com.sistema.faculdade.model.Curso;
import com.sistema.faculdade.model.Professor;

import jakarta.validation.constraints.NotBlank;

public class DisciplinaDTO {
	private Long id;
	
	@NotBlank(message = "O nome da disciplina é obrigatório!")
	private String nome;
	
	private List<Professor> professores;
	
	private List<Curso> cursos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}