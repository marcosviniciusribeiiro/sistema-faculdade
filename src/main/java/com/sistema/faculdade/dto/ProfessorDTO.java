package com.sistema.faculdade.dto;

import java.util.List;

import com.sistema.faculdade.model.Disciplina;

import jakarta.validation.constraints.NotBlank;

public class ProfessorDTO {
	private Long id;
	
	@NotBlank(message = "O nome do professor é obrigatório!")
	private String nome;
	
	private List<Disciplina> disciplinas;

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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}