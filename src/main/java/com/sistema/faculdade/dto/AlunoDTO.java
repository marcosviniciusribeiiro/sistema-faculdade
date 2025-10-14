package com.sistema.faculdade.dto;

import com.sistema.faculdade.model.Curso;
import com.sistema.faculdade.model.Endereco;

import jakarta.validation.constraints.NotBlank;

public class AlunoDTO {
	private Long id;
	
	@NotBlank(message = "O nome do aluno é obrigatório.")
	private String nome;
	
	private Endereco endereco;
	
	private Curso curso;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
