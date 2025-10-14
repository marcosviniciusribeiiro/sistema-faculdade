package com.sistema.faculdade.dto;

import java.util.List;

import com.sistema.faculdade.model.Aluno;

import jakarta.validation.constraints.NotBlank;

public class CursoDTO {
	private Long id;
	
	@NotBlank(message = "O nome do curso é obrigatório!")
	private String nome;
	
	private List<Aluno> alunos;

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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
