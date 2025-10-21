package com.sistema.faculdade.dto;

import jakarta.validation.constraints.NotBlank;

public class AlunoDTO {
	private Long id;
	
	@NotBlank(message = "O nome do aluno é obrigatório.")
	private String nome;
	
	private EnderecoDTO endereco = new EnderecoDTO();
	
	private Long cursoId;

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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
}
